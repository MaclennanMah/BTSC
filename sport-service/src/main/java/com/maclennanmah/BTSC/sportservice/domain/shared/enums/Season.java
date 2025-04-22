package com.maclennanmah.BTSC.sportservice.domain.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Season {
  @JsonProperty("WINTER") WINTER,
  @JsonProperty("SUMMER") SUMMER,
  @JsonProperty("FALL") FALL,
  @JsonProperty("SPRING") SPRING;

}
