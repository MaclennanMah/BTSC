package com.maclennanmah.BTSC.league_catalog_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Season {
  @JsonProperty("WINTER") WINTER,
  @JsonProperty("SUMMER") SUMMER,
  @JsonProperty("FALL") FALL,
  @JsonProperty("SPRING") SPRING;

}
