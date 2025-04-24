package com.maclennanmah.BTSC.sportservice.domain.league;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
interface LeagueMapper {

  @Mapping(target = "street", source = "address.street")
  @Mapping(target = "city", source = "address.city")
  @Mapping(target = "province", source = "address.province")
  @Mapping(target = "zipCode", source = "address.zipCode")
  @Mapping(target = "country", source = "address.country")
  League leagueEntityToLeague(LeagueEntity leagueEntity);

  @InheritInverseConfiguration
  LeagueEntity leagueToLeagueEntity(League league);

}
