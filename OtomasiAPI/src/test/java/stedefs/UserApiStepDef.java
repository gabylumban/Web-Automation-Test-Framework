package stepdefs;

import config.BaseTest;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import requests.UserRequest;

import static org.junit.Assert.*;

public class UserApiStepDef extends BaseTest {

    private final UserRequest userRequest = new UserRequest();

    @Given("I send GET request to get user with id {int}")
    public void i_send_get_request_to_get_user_with_id(Integer userId) {
        response = userRequest.getUser(userId);
    }

    @Given("I send GET request to get users page {int}")
    public void i_send_get_request_to_get_users_page(Integer page) {
        response = userRequest.getUsersByPage(page);
    }

    @Then("Response status should be {int}")
    public void response_status_should_be(Integer expectedStatus) {
        assertEquals(expectedStatus.intValue(), response.getStatusCode());
    }

    @Then("Response body should contain {string}")
    public void response_body_should_contain(String key) {
        if (key != null && !key.isEmpty()) {
            assertTrue(response.getBody().asString().contains(key));
        }
    }
}

