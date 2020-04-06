package com.appliti.homer.infractruture.http.filter.authenticate;

import lombok.RequiredArgsConstructor;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements UserDetailsService {

    private final UsersSecurityRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(final String token) throws UsernameNotFoundException {
        final Optional<UserSecurityEntity> optionalUser = usersRepository.findByToken(token);

        final UserSecurityEntity UserSecurityEntity = optionalUser.orElseThrow(() -> new UsernameNotFoundException(
                "Active user not found"));
        return UserSecurityEntity.toCustomUserDetails();
    }
}

