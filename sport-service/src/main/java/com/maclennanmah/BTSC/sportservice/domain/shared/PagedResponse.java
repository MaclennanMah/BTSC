package com.maclennanmah.BTSC.sportservice.domain.shared;

import java.util.List;
import lombok.Builder;

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
