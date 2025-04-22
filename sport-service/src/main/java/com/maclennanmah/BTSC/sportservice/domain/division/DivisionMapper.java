package com.maclennanmah.BTSC.sportservice.domain.division;

public class DivisionMapper {

  public static DivisionEntity toDivisionEntity(Division division) {
    DivisionEntity divisionEntity = new DivisionEntity();
    divisionEntity.setName(division.name());
    divisionEntity.setStatus(division.status());
    return divisionEntity;
  }

  public static Division toDTO(DivisionEntity divisionEntity) {
    return Division.builder()
        .name(divisionEntity.getName())
        .status(divisionEntity.getStatus())
        .build();
  }
}
