package com.appliti.homer.bussiness.incoming.user.register;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
class HomeService {

    private final HomeRepository homeRepository;

    HomeEntity register(final AbstractHome abstractHome) {
        if (abstractHome instanceof NewHome) {
            final NewHome newHome = (NewHome) abstractHome;
            HomeEntity homeEntity = HomeEntity.builder()
                                              .name(newHome.getName())
                                              .city(newHome.getCity())
                                              .street(newHome.getStreet())
                                              .number(newHome.getNumber())
                                              .build();
            homeEntity = homeRepository.save(homeEntity);

            return homeEntity;
        } else if (abstractHome instanceof ExistedHome) {
            final ExistedHome existedHome = (ExistedHome) abstractHome;

            return homeRepository.findById(existedHome.getId())
                                 .orElseThrow(() -> new EntityNotFoundException("Provided home not found"));
        }

        throw new IllegalStateException("Home should be provided to register new user");
    }
}
