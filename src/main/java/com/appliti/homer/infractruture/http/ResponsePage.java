package com.appliti.homer.infractruture.http;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.data.domain.Page;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class ResponsePage<T> {

    private List<T> data;
    private Pageable pageable;

    public ResponsePage(final List<T> data, final Page page) {
        this.data = data;
        pageable = new Pageable(page.getNumber(),
                                page.getSize(),
                                page.getTotalPages(),
                                page.getTotalElements(),
                                page.isLast(),
                                page.isFirst(),
                                page.isEmpty());
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    private static class Pageable {

        private final int pageNumber;
        private final int pageSize;
        private final int pagesCount;
        private final Long totalElements;
        private final boolean lastPage;
        private final boolean firstPage;
        private final boolean emptySet;
    }
}
