package com.appliti.homer.infractruture.http;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Setter
@Getter
@NoArgsConstructor
public class RequestPage {

    private Integer pageNo;
    private Integer pageSize;
    private String sortBy;

    public Pageable toPageable() {
        if (StringUtils.isEmpty(sortBy)) {
            return PageRequest.of(pageNo, pageSize);
        } else {
            return PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        }
    }
}
