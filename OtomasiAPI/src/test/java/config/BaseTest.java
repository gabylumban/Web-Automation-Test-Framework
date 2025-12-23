package config;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class BaseTest {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.requestSpecification =
                RestAssured.given()
                        .header("x-api-key", "reqres_cc81c75fbb694842aafef73f927846ed")
                        .contentType("application/json");

    }

}
