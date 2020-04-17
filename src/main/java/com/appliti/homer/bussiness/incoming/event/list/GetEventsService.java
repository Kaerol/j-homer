package com.appliti.homer.bussiness.incoming.event.list;

import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.appliti.homer.infractruture.http.ResponsePage;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@RequiredArgsConstructor
class GetEventsService {

    private final SearchCondition searchCondition = new SearchCondition();
    private final GetEventsRepository repository;

    ResponsePage<GetEventResponse> getEvents(final GetEventFilterRequest eventFilter, final Pageable pageable) {
        final Predicate whereCondition = searchCondition.prepareSearchCondition(eventFilter);
        final Page<GetEventsEntity> page = repository.findAll(whereCondition, pageable);

        final List<GetEventResponse> collect = StreamSupport.stream(page.spliterator(), false)
                                                            .map(GetEventsEntity::toCreateEventResponse)
                                                            .collect(Collectors.toList());

        return new ResponsePage<>(collect, page);
    }
}
