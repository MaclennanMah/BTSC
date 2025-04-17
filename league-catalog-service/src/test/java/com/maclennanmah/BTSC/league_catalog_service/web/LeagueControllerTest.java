package com.maclennanmah.BTSC.league_catalog_service.web;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;

import com.maclennanmah.BTSC.league_catalog_service.AbstractIT;
import com.maclennanmah.BTSC.league_catalog_service.TestHelper;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
public class LeagueControllerTest extends AbstractIT {

  @Test
  public void getAll() {
    given().contentType(ContentType.JSON).
        when()
        .get("/api/leagues")
        .then()
        .statusCode(200)
        .body("data", hasSize(1))
        .body("totalElements", is(1))
        .body("pageNumber", is(1))
        .body("totalPages", is(1))
        .body("isFirst", is(true))
        .body("isLast", is(true))
        .body("hasNext", is(false))
        .body("hasPrevious", is(false));
  }

  @Test
  public void createLeague() {
    given()
        .contentType(ContentType.JSON)
        .body(TestHelper.getLeagueJSON())
        .when()
        .post("/api/leagues")
        .then()
        .statusCode(201)
        .body("name", is("Spring League"))
        .body("description", is("A competitive spring league"))
        .body("gender", is("CO_ED"))
        .body("skillLevel", is("RECREATIONAL"))
        .body("season", is("SPRING"))
        .body("startDate", is("2024-03-01T10:00:00Z"))
        .body("dayOfWeek", is("SATURDAY"))
    ;
  }
}
