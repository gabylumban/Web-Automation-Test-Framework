package requests;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserRequest {

    public static Response getUsers(int page) {
        return given()
                .queryParam("page", page)
                .when()
                .get("/users");
    }

    public static Response getUserById(int id) {
        return given()
                .when()
                .get("/users/" + id);
    }
}
