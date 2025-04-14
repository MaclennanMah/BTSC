package com.maclennanmah.BTSC.league_catalog_service.domain;

import java.util.List;

public record PagedResponse<T>(
    List<T> data,
    long totalElements,
    int pageNumber,
    int totalPages,
    boolean isFirst,
    boolean isLast,
    boolean hasNext,
    boolean hasPrevious
) {

}
