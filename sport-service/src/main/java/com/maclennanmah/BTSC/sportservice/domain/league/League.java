package com.maclennanmah.BTSC.sportservice.domain.league;

import com.maclennanmah.BTSC.sportservice.domain.shared.enums.LeagueGender;
import com.maclennanmah.BTSC.sportservice.domain.shared.enums.Season;
import com.maclennanmah.BTSC.sportservice.domain.shared.enums.SkillLevel;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.ZonedDateTime;
import java.util.Date;
import lombok.Builder;

@Builder
public record League(
    String name,
    String description,
    LeagueGender gender,
    SkillLevel skillLevel,
    Season season,
    Date startDate,
    Date endDate,
    Date registrationDeadline,
    int seasonLength,
    int teamSize,
    boolean officiated,
    DayOfWeek dayOfWeek,
    ZonedDateTime startTime,
    ZonedDateTime endTime,
    BigDecimal price,
    String street,
    String city,
    String province,
    String zipCode,
    String country
) {

}
