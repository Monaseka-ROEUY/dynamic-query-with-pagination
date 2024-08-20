package com.kaka.simplified.dynamic_query.utils;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public interface PageUtil {
    int DEFAULT_PAGE_NUMBER = 1;
    int DEFAULT_PAGE_SIZE = 10;

    static Pageable getPageable(int pageNumber, int pageSize) {
        if (pageNumber < DEFAULT_PAGE_NUMBER) {
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if (pageSize < DEFAULT_PAGE_SIZE) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        return PageRequest.of(pageNumber - 1, pageSize);
    }
}
