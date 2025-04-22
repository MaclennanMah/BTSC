package com.maclennanmah.BTSC.sportservice.domain.shared.enums;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Status {
  @JsonProperty("OPEN") OPEN,
  @JsonProperty("CLOSED") CLOSED;

}

