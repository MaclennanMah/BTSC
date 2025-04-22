package com.maclennanmah.BTSC.sportservice.domain.league;

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
        .street(leagueEntity.getAddress().getStreet())
        .city(leagueEntity.getAddress().getCity())
        .province(leagueEntity.getAddress().getProvince())
        .zipCode(leagueEntity.getAddress().getZipCode())
        .country(leagueEntity.getAddress().getCountry())
        .build();
  }

  //TODO: code duplication
  public static LeagueEntity toLeagueEntity(League league) {
    LeagueEntity newLeague = new LeagueEntity();
    newLeague.setName(league.name());
    newLeague.setDescription(league.description());
    newLeague.setGender(league.gender());
    newLeague.setSkillLevel(league.skillLevel());
    newLeague.setSeason(league.season());
    newLeague.setStartDate(league.startDate());
    newLeague.setEndDate(league.endDate());
    newLeague.setRegistrationDeadline(league.registrationDeadline());
    newLeague.setSeasonLength(league.seasonLength());
    newLeague.setTeamSize(league.teamSize());
    newLeague.setOfficiated(league.officiated());
    newLeague.setDayOfWeek(league.dayOfWeek());
    newLeague.setStartTime(league.startTime());
    newLeague.setEndTime(league.endTime());
    newLeague.setPrice(league.price());
    newLeague.getAddress().setStreet(league.street());
    newLeague.getAddress().setCity(league.city());
    newLeague.getAddress().setProvince(league.province());
    newLeague.getAddress().setZipCode(league.zipCode());
    newLeague.getAddress().setCountry(league.country());
    return newLeague;
  }
}
