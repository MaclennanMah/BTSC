package com.maclennanmah.BTSC.sportservice.domain.division;

import com.maclennanmah.BTSC.sportservice.domain.shared.enums.Status;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record Division(
    @NotBlank String name,
    @NotNull Status status
    ) {
}
