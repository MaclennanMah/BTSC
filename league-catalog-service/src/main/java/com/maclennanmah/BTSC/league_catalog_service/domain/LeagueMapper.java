package com.maclennanmah.BTSC.league_catalog_service.domain;

class LeagueMapper {

  public static League toLeagueDTO(LeagueEntity leagueEntity) {
    return League.builder()
        .name(leagueEntity.getName())
        .description(leagueEntity.getDescription())
        .gender(leagueEntity.getGender())
        .skillLevel(leagueEntity.skillLevel)
        .season(leagueEntity.getSeason())
        .startDate(leagueEntity.getStartDate())
        .endDate(leagueEntity.getEndDate())
        .registrationDeadline(leagueEntity.getRegistrationDeadline())
        .seasonLength(leagueEntity.getSeasonLength())
        .teamSize(leagueEntity.getTeamSize())
        .officiated(leagueEntity.isOfficiated())
        .dayOfWeek(leagueEntity.getDayOfWeek())
        .startTime(leagueEntity.getStartTime())
        .endTime(leagueEntity.getEndTime())
        .price(leagueEntity.getPrice())
        .build();
  }

  public static LeagueEntity toLeagueEntity(League league) {
    return LeagueEntity.builder()
        .name(league.name())
        .description(league.description())
        .gender(league.gender())
        .skillLevel(league.skillLevel())
        .season(league.season())
        .startDate(league.startDate())
        .endDate(league.endDate())
        .registrationDeadline(league.registrationDeadline())
        .seasonLength(league.seasonLength())
        .teamSize(league.teamSize())
        .officiated(league.officiated())
        .dayOfWeek(league.dayOfWeek())
        .startTime(league.startTime())
        .endTime(league.endTime())
        .price(league.price())
        .build();
  }
}
