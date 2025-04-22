package com.maclennanmah.BTSC.sportservice.domain.shared.exceptions;

public class LeagueNotFoundException extends RuntimeException {

  public LeagueNotFoundException(String message) {
    super(message);
  }

  public static LeagueNotFoundException forId(Long id) {
    return new LeagueNotFoundException("league with id " + id + " not found");
  }
}
