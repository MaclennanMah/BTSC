package com.maclennanmah.BTSC.league_catalog_service.domain;

import com.fasterxml.jackson.annotation.JsonProperty;


public enum Surface {
  @JsonProperty("HARD_GROUND") HARD_GROUND,
  @JsonProperty("FIRM_GROUND") FIRM_GROUND,
  @JsonProperty("SOFT_GROUND") SOFT_GROUND,
  @JsonProperty("ARTIFICIAL_GROUND") ARTIFICIAL_GROUND,
  @JsonProperty("TURF") TURF,
  @JsonProperty("INDOOR") INDOOR;

}
