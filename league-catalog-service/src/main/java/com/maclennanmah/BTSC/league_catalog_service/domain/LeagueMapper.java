package com.maclennanmah.BTSC.league_catalog_service.domain;

class LeagueMapper {

  public static League toLeague(LeagueEntity leagueEntity) {
    return new League(
        leagueEntity.getName(),
        leagueEntity.getDescription(),
        leagueEntity.getGender(),
        leagueEntity.getSkillLevel(),
        leagueEntity.getSeason(),
        leagueEntity.getStartDate(),
        leagueEntity.getEndDate(),
        leagueEntity.getRegistrationDeadline(),
        leagueEntity.getSeasonLength(),
        leagueEntity.getTeamSize(),
        leagueEntity.isOfficiated(),
        leagueEntity.getDayOfWeek(),
        leagueEntity.getStartTime(),
        leagueEntity.getEndTime(),
        leagueEntity.getPrice()
    );
  }
}
