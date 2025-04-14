package com.maclennanmah.BTSC.league_catalog_service.domain;

public class LeagueNotFoundException extends RuntimeException {

  public LeagueNotFoundException(String message) {
    super(message);
  }

  public static LeagueNotFoundException forId(Long id) {
    return new LeagueNotFoundException("league with id " + id + " not found");
  }
}
