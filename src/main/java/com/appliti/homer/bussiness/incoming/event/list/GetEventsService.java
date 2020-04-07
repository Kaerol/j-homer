package com.appliti.homer.bussiness.incoming.event.list;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
class GetEventsService {

    private final SearchCondition searchCondition = new SearchCondition();
    private final GetEventsRepository repository;

    List<GetEventResponse> getEvents(final GetEventFilterRequest eventFilter) {
        final Predicate whereCondition = searchCondition.prepareSearchCondition(eventFilter);
        final Iterable<GetEventsEntity> all = repository.findAll(whereCondition);

        return StreamSupport.stream(all.spliterator(), false)
                            .map(GetEventsEntity::toCreateEventResponse)
                            .collect(Collectors.toList());
    }
}
