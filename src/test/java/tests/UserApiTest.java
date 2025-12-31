package tests;

import config.BaseTest;
import org.junit.jupiter.api.Test;
import requests.UserRequest;
import utils.TestDataUtil;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseTest {
    //Test Positif
    @Test
    void getUsers_validPage(){
        UserRequest.getUsers(TestDataUtil.VALID_PAGE)
                .then()
                .statusCode(200)
                .body("data" , not(empty()))
                .log().all();
    }
    //Test Negatif
    @Test
    void getUserById_invalidId(){
        UserRequest.getUserById(TestDataUtil.INVALID_USER_ID)
                .then()
                .log().all()
                .statusCode(404)
                .body(equalTo("{}"));
    }
    @Test
    void getUsers_invalidPage(){
        UserRequest.getUsers(-1)
                .then()
                .log().all()
                .statusCode(200);
    }
    //Test Batas
    @Test
    void getUsers_boundaryPageZero(){
        UserRequest.getUsers(TestDataUtil.BOUNDARY_PAGE)
                .then()
                .log().all()
                .statusCode(200)
                .body("page" , equalTo(1));
    }

}
