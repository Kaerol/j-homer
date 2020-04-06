package com.appliti.homer.bussiness.incoming.event.list;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
class GetEventsService {

    private final GetEventsRepository repository;

    List<GetEventsEntity> getEvents() {
        return repository.findAll();
    }
}
