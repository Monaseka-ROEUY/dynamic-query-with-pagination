package com.kaka.simplified.dynamic_query.dto;

import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDto {
    private List<?> content;
    private PaginationDto pagination;

    public PageDto(Page<?> page) {
        this.content = page.getContent();
        this.pagination = PaginationDto.builder()
                .empty(page.isEmpty())
                .first(page.isFirst())
                .last(page.isLast())
                .pageSize(page.getPageable().getPageSize())
                .pageNumber(page.getPageable().getPageNumber() + 1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .build();
    }
}
