package fr.zenika;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EvenementResourceTest {

    @Test
    public void testListEvenementEndpoint() {
        given()
          .when().get("/v1/evenements")
          .then()
             .statusCode(200)
             .body("nom", hasItems("DevFest Nantes", "DevFest Nantes", "BattleDev"));
    }

    @Test
    public void testGetEvenementEndpoint() {
        given()
                .when().get("/v1/evenements/1")
                .then()
                .statusCode(200)
                .body("nom", is("DevFest Nantes"));
    }

    @Test
    public void testAddEvenementEndpoint() {
        given()
                .when()
                .body(new Evenement("MixIT", LocalDate.of(2020, Month.APRIL, 29), 2))
                .contentType(ContentType.JSON)
                .post("/v1/evenements")
                .then()
                .statusCode(200)
                .body("id", notNullValue());
    }
}
