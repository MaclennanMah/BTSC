package com.maclennanmah.BTSC.league_catalog_service.domain;

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
    BigDecimal price
) {

}
