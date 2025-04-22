package com.maclennanmah.BTSC.sportservice.domain.shared.exceptions;

public class PlayerNotFoundException extends RuntimeException {

  public PlayerNotFoundException(String message) {
    super(message);
  }

  public static PlayerNotFoundException forId(Long id) {
    return new PlayerNotFoundException("Player with id " + id + " Not Found");
  }

}
