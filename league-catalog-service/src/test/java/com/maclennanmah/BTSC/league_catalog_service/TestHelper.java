package com.maclennanmah.BTSC.league_catalog_service;

public class TestHelper {

  public static String getLeagueJSON() {
    return """
            {
                "name": "Spring League",
                "description": "A competitive spring league",
                "gender": "CO_ED",
                "skillLevel": "RECREATIONAL",
                "season": "SPRING",
                "startDate": "2024-03-01T10:00:00Z",
                "endDate": "2024-03-01T12:00:00Z",
                "registrationDeadline": "2024-03-01T10:00:00Z",
                "seasonLength": 10,
                "teamSize": 8,
                "officiated": true,
                "dayOfWeek": "SATURDAY",
                "startTime": "2024-03-01T10:00:00Z",
                "endTime": "2024-03-01T12:00:00Z",
                "price": 120.00
            }
        """;
  }
}