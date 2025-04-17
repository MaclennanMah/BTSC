package com.maclennanmah.BTSC.league_catalog_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum SkillLevel {
  @JsonProperty("RECREATIONAL") RECREATIONAL,
  @JsonProperty("INTERMEDIATE") INTERMEDIATE,
  @JsonProperty("ADVANCED") ADVANCED;
}
