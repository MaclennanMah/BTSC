package com.maclennanmah.BTSC.sportservice.domain.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum SkillLevel {
  @JsonProperty("RECREATIONAL") RECREATIONAL,
  @JsonProperty("INTERMEDIATE") INTERMEDIATE,
  @JsonProperty("ADVANCED") ADVANCED;
}
