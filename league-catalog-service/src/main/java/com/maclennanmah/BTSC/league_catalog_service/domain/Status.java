package com.maclennanmah.BTSC.league_catalog_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Status {
  @JsonProperty("OPEN") OPEN,
  @JsonProperty("CLOSED") CLOSED;

}

