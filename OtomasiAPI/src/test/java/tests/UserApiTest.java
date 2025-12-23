package tests;

import config.BaseTest;
import requests.UserRequest;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.hamcrest.core.AnyOf;
import org.junit.jupiter.api.Test;
import utils.TestDataUtil;

import static org.hamcrest.Matchers.*;

import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseTest {

    //Tes Positif

    @Test
    void getUsers_validPage() {
        UserRequest.getUsers(TestDataUtil.VALID_PAGE)
                .then()
                .statusCode(200)
                .body("data", not(empty()))
                .log().all();
    }
    //Tes Negatif
    @Test
    void getUserById_invalidId() {
        UserRequest.getUserById(TestDataUtil.INVALID_USER_ID)
                .then()
                .log().all()
                .statusCode(404)
                .body(equalTo("{}"));
    }
    @Test
        void getUsers_invalidPage() {
            UserRequest.getUsers(-1)
                    .then()
                    .log().all()
                    .statusCode(200);
    }
    //Test Batas
    @Test
    void getUsers_boundaryPageZero() {
        UserRequest.getUsers(TestDataUtil.BOUNDARY_PAGE)
                .then()
                .log().all()
                .statusCode(200)
                .body("page", equalTo(1));

    }

    }


