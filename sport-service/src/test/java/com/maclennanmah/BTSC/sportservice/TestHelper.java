package com.maclennanmah.BTSC.sportservice;

public class TestHelper {

  public static String getCoedLeagueJSON() {
    return """
            {
                "name": "Spring League",
                "description": "A competitive spring league",
                "gender": "CO_ED",
                "skillLevel": "RECREATIONAL",
                "season": "SPRING",
                "startDate": "2024-03-01T10:00:00Z",
                "endDate": "2024-06-01T12:00:00Z",
                "registrationDeadline": "2024-02-01T10:00:00Z",
                "seasonLength": 10,
                "teamSize": 8,
                "officiated": true,
                "dayOfWeek": "SATURDAY",
                "startTime": "2024-03-01T10:00:00Z",
                "endTime": "2024-03-01T12:00:00Z",
                "price": 120.00,
                "street": "123 Main St",
                "city": "Toronto",
                "province": "ON",
                "zipCode": "M1M 1M1",
                "country": "Canada"
            }
        """;
  }

  public static String getMensLeagueJSON() {
    return """
            {
                "name": "Summer League",
                "description": "A fun summer league",
                "gender": "MEN",
                "skillLevel": "INTERMEDIATE",
                "season": "SUMMER",
                "startDate": "2024-07-01T10:00:00Z",
                "endDate": "2024-09-01T12:00:00Z",
                "registrationDeadline": "2024-06-01T10:00:00Z",
                "seasonLength": 8,
                "teamSize": 10,
                "officiated": false,
                "dayOfWeek": "SUNDAY",
                "startTime": "2024-07-01T10:00:00Z",
                "endTime": "2024-07-01T12:00:00Z",
                "price": 150.00,
                "street": "456 Elm St",
                "city": "Vancouver",
                "province": "BC",
                "zipCode": "V5K 0A1",
                "country": "Canada"
            }
        """;
  }

  public static String getPlayerJSON() {
    return """
        {
        "firstName": "John",
        "lastName": "Doe",
        "gender": "Male",
        "email": "johndoe@gmail.com",
        "phoneNumber": "123-342-1298",
        "birthDate": "2024-07-01"
        }
        """;
  }

  public static String getDivisionJSON() {
    return """
        {
        "name": "Division C",
        "status": "OPEN"
        }
        """;
  }

}