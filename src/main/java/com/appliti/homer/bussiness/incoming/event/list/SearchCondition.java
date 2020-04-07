package com.appliti.homer.bussiness.incoming.event.list;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

import java.time.ZonedDateTime;

class SearchCondition {

    private static final QGetEventsEntity contEquation = QGetEventsEntity.getEventsEntity;
    private BooleanBuilder predicate;

    Predicate prepareSearchCondition(final GetEventFilterRequest eventFilter) {
        predicate = new BooleanBuilder();
        deviceIdx(eventFilter.getDeviceIdx()).deviceName(eventFilter.getDeviceName())
                                             .description(eventFilter.getDescription())
                                             .value(eventFilter.getValue())
                                             .creationDateAfter(eventFilter.getCreationDateAfter())
                                             .creationDateBefore(eventFilter.getCreationDateBefore());

        return predicate;
    }

    private SearchCondition creationDateBefore(final ZonedDateTime lastUpdateBefore) {
        if (lastUpdateBefore != null) {
            predicate.and(contEquation.creationDate.loe(lastUpdateBefore));
        }
        return this;
    }

    private SearchCondition creationDateAfter(final ZonedDateTime lastUpdateAfter) {
        if (lastUpdateAfter != null) {
            predicate.and(contEquation.creationDate.goe(lastUpdateAfter));
        }
        return this;
    }

    private SearchCondition value(final String value) {
        if (value != null) {
            predicate.and(contEquation.value.eq(value));
        }
        return this;
    }

    private SearchCondition description(final String description) {
        if (description != null) {
            predicate.and(contEquation.description.contains(description));
        }
        return this;
    }

    private SearchCondition deviceName(final String deviceName) {
        if (deviceName != null) {
            predicate.and(contEquation.deviceEntity.name.eq(deviceName));
        }
        return this;
    }

    private SearchCondition deviceIdx(final String deviceIdx) {
        if (deviceIdx != null) {
            predicate.and(contEquation.deviceEntity.idx.eq(deviceIdx));
        }
        return this;
    }
}
