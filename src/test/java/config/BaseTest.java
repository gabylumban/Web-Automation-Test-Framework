package config;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;

public class BaseTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://reqres.in/api";
        RestAssured.requestSpecification = RestAssured
                .given()
                .filter(new AllureRestAssured()) // 🔥 ini kuncinya
                .header("x-api-key", "reqres_cc81c75fbb694842aafef73f927846ed")
                .contentType("application/json")
                .accept("application/json");
    }
}
