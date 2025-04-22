package com.maclennanmah.BTSC.sportservice.domain.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum LeagueGender {
  @JsonProperty("MEN") MEN,
  @JsonProperty("WOMEN") WOMEN,
  @JsonProperty("CO_ED") CO_ED;

}
