package com.maclennanmah.BTSC.league_catalog_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum LeagueGender {
  @JsonProperty("MEN") MEN,
  @JsonProperty("WOMEN") WOMEN,
  @JsonProperty("CO_ED") CO_ED;

}
