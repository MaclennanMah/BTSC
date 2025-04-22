package com.maclennanmah.BTSC.sportservice.web;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.maclennanmah.BTSC.sportservice.AbstractIT;
import com.maclennanmah.BTSC.sportservice.TestHelper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class LeagueControllerTest extends AbstractIT {

  @Test
  public void getAll() {
    given().contentType(ContentType.JSON).
        when()
        .get("/leagues")
        .then()
        .statusCode(200)
        .body("data", hasSize(3))
        .body("totalElements", is(3))
        .body("pageNumber", is(1))
        .body("totalPages", is(1))
        .body("isFirst", is(true))
        .body("isLast", is(true))
        .body("hasNext", is(false))
        .body("hasPrevious", is(false));
  }

  @Test
  public void getByID() {
    given().contentType(ContentType.JSON).
        when()
        .get("/leagues/{leagueId}", 33)
        .then()
        .statusCode(200)
        .body("name", is("Fall League"))
        .body("description", is("A beginner-friendly fall league"))
        .body("gender", is("WOMEN"));
  }

  @Test
  public void createLeague() {
    given()
        .contentType(ContentType.JSON)
        .body(TestHelper.getCoedLeagueJSON())
        .when()
        .post("/leagues")
        .then()
        .statusCode(201)
        .body("name", is("Spring League"))
        .body("description", is("A competitive spring league"))
        .body("gender", is("CO_ED"))
        .body("skillLevel", is("RECREATIONAL"))
        .body("season", is("SPRING"))
        .body("startDate", containsString("2024-03-01T10:00:00"))
        .body("endDate", containsString("2024-06-01T12:00:00"))
        .body("price", is(120.0F))
        .body("registrationDeadline", containsString("2024-02-01T10:00:00"))
        .body("seasonLength", is(10))
        .body("teamSize", is(8))
        .body("officiated", is(true))
        .body("street", is("123 Main St"))
        .body("province", is("ON"))
        .body("zipCode", is("M1M 1M1"))
        .body("country", is("Canada"))
        .body("startTime", containsString("10:00:00"))
        .body("endTime", containsString("12:00:00"))
        .body("dayOfWeek", is("SATURDAY"))
        .body("city", is("Toronto"))
    ;
  }

  @Test
  public void deleteLeague() {
    given()
        .contentType(ContentType.JSON)
        .when()
        .delete("/leagues/{leagueId}", 22)
        .then()
        .statusCode((204));
  }

  @Test
  public void updateLeague() {
    given()
        .contentType(ContentType.JSON)
        .body(TestHelper.getMensLeagueJSON())
        .when()
        .put("/leagues/{leagueId}", 11)
        .then()
        .statusCode(200)
        .body("name", is("Summer League"))
        .body("description", is("A fun summer league"))
        .body("gender", is("MEN"))
        .body("skillLevel", is("INTERMEDIATE"))
        .body("season", is("SUMMER"))
        .body("startDate", containsString("2024-07-01T10:00:00"))
        .body("endDate", containsString("2024-09-01T12:00:00"))
        .body("price", is(150.0F))
        .body("registrationDeadline", containsString("2024-06-01T10:00:00"))
        .body("seasonLength", is(8))
        .body("teamSize", is(10))
        .body("officiated", is(false))
        .body("street", is("456 Elm St"))
        .body("city", is("Vancouver"))
        .body("province", is("BC"))
        .body("zipCode", is("V5K 0A1"))
        .body("country", is("Canada"))
        .body("startTime", containsString("10:00:00"))
        .body("endTime", containsString("12:00:00"))
        .body("dayOfWeek", is("SUNDAY"));


  }

}
