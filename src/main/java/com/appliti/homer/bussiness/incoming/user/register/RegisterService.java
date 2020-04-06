package com.appliti.homer.bussiness.incoming.user.register;

import lombok.RequiredArgsConstructor;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.appliti.homer.infractruture.persistence.UserStatus;

import java.util.regex.Pattern;

@Service
@RequiredArgsConstructor
class RegisterService {

    private static final String regex = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
    private static final Pattern pattern = Pattern.compile(regex);
    private final HomeService homeService;
    private final RegisterRepository repository;

    RegisterResponse register(final RegisterRequest registerRequest) {
        validateRegister(registerRequest);

        final HomeEntity homeEntity = homeService.register(registerRequest.getHome());

        final RegisterEntity registerEntity = RegisterEntity.builder()
                                                            .homeId(homeEntity.getId())
                                                            .login(registerRequest.getLogin())
                                                            .password(registerRequest.getPassword())
                                                            .mail(registerRequest.getMail())
                                                            .registerToken(RandomStringUtils.randomAlphabetic(25))
                                                            .status(UserStatus.INACTIVE)
                                                            .role(resolveRole(registerRequest.getHome()))
                                                            .build();

        final RegisterEntity entity = repository.save(registerEntity);

        return RegisterResponse.builder()
                               .id(entity.getId())
                               .token(homeEntity.getToken())
                               .build();
    }

    private RoleRegisterEntity resolveRole(final AbstractHome home) {
        final RoleRegisterEntity.RoleRegisterEntityBuilder builder = RoleRegisterEntity.builder();
        if (home instanceof NewHome) {
            builder.role("ADMIN");
        } else {
            builder.role("USER");
        }
        return builder.build();
    }

    private void validateRegister(final RegisterRequest registerRequest) {
        Assert.isTrue(registerRequest.getPassword()
                                     .equals(registerRequest.getConfirmPassword()),
                      "Password and confirmPassword not match.");

        Assert.isTrue(pattern.matcher(registerRequest.getMail())
                             .find(), "Incorrect mail format");
    }
}
