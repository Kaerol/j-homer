package com.appliti.homer.bussiness.incoming.home;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class GetHomesService implements GetHomesFacade {

    private final GetHomesRepository repository;

    @Override
    public boolean homeExist(final String token) {
        return repository.findByToken(token)
                         .isPresent();
    }

    List<GetHomeEntity> getHomes() {
        return repository.findAll();
    }
}
