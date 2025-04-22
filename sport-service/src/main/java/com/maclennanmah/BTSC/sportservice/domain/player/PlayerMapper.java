package com.maclennanmah.BTSC.sportservice.domain.player;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

class PlayerMapper {

  public static Player toDTO(@NotNull @Valid PlayerEntity playerEntity) {
    return Player.builder()
        .firstName(playerEntity.getFirstName())
        .lastName(playerEntity.getLastName())
        .phoneNumber(playerEntity.getPhoneNumber())
        .birthDate(playerEntity.getBirthDate())
        .gender(playerEntity.getGender())
        .email(playerEntity.getEmail())
        .build();
  }

  public static PlayerEntity toPlayerEntity(@NotNull @Valid Player player) {
    PlayerEntity playerEntity = new PlayerEntity();
    playerEntity.setFirstName(player.firstName());
    playerEntity.setLastName(player.lastName());
    playerEntity.setPhoneNumber(player.phoneNumber());
    playerEntity.setBirthDate(player.birthDate());
    playerEntity.setGender(player.gender());
    playerEntity.setEmail(player.email());
    return playerEntity;
  }
}
