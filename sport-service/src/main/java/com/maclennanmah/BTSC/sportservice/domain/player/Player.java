package com.maclennanmah.BTSC.sportservice.domain.player;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import java.util.Date;
import lombok.Builder;

@Builder
public record Player(
    @NotBlank String firstName,
    @NotBlank String lastName,
    @Email @NotBlank String email,
    @NotBlank String phoneNumber,
    @Past Date birthDate,
    @NotBlank String gender
) {

}
