package stepdef;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import requests.UserRequest;

import static org.hamcrest.Matchers.*;

public class UserApiStepDef {

    private Response response;
    private int page;
    private int userId;

    @Given("I set page to {int}")
    public void i_set_page_to(Integer page) {
        this.page = page;
    }

    @Given("I set user id to {int}")
    public void i_set_user_id_to(Integer id) {
        this.userId = id;
    }

    @When("I request GET /users")
    public void i_request_get_users() {
        response = UserRequest.getUsers(page);
    }

    @When("I request GET /users/{id}")
    public void i_request_get_user_by_id() {
        response = UserRequest.getUserById(userId);
    }

    @Then("I receive status code {int}")
    public void i_receive_status_code(Integer statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("response contains users list")
    public void response_contains_users_list() {
        response.then().body("data", not(empty()));
    }

    @Then("response page is {int}")
    public void response_page_is(Integer expectedPage) {
        response.then().body("page", equalTo(expectedPage));
    }
}
