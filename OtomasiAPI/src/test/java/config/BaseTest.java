package config;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class BaseTest {
    protected Response response;

    static {
        RestAssured.baseURI = "https://reqres.in/api";
    }

    protected Response sendGet(String endpoint) {
        response = RestAssured.get(endpoint);
        return response;
    }
}
