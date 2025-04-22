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
public class PlayerControllerTest extends AbstractIT {

  @Test
  public void getAll() {
    given().contentType(ContentType.JSON)
        .when()
        .get("/players")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("data", hasSize(5))
        .body("totalElements", is(5))
        .body("pageNumber", is(1))
        .body("totalPages", is(1))
        .body("isFirst", is(true))
        .body("isLast", is(true))
        .body("hasNext", is(false))
        .body("hasPrevious", is(false));
  }

  @Test
  public void getByID() {
    given().contentType(ContentType.JSON)
        .when()
        .get("/players/{playerID}", 11)
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("email", is("player1@example.com"))
        .body("firstName", is("John"))
        .body("lastName", is("Doe"))
        .body("gender", is("Male"))
        .body("phoneNumber", is("123-456-7890"))
        .body("birthDate", containsString("1990-01-01"));
  }

  @Test
  public void getByIDNotFound() {
    given().contentType(ContentType.JSON)
        .when()
        .get("/players/{playerID}", 0)
        .then()
        .statusCode(404);
  }

  @Test
  public void create() {
    given().contentType(ContentType.JSON)
        .body(TestHelper.getPlayerJSON())
        .when()
        .post("/players")
        .then()
        .statusCode(201)
        .contentType(ContentType.JSON)
        .body("email", is("johndoe@gmail.com"))
        .body("firstName", is("John"))
        .body("lastName", is("Doe"))
        .body("gender", is("Male"))
        .body("phoneNumber", is("123-342-1298"))
        .body("birthDate", containsString("2024-07-01"));

    given().contentType(ContentType.JSON)
        .when().get("/players")
        .then()
        .statusCode(200)
        .contentType(ContentType.JSON)
        .body("data", hasSize(6));
  }

  @Test
  public void delete() {
    given().contentType(ContentType.JSON)
        .when()
        .delete("/players/{playerID}", 11)
        .then()
        .statusCode(204);

    given().contentType(ContentType.JSON)
        .when().get("/players/{playerID}", 11)
        .then()
        .statusCode(404);
  }
}
