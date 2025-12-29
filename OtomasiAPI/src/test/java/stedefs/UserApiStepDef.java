package stepdefs;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import requests.UserRequest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class UserApiStepDef {

    int page;
    int userId;
    Response response;

    @Given("I set page to {int}")
    public void setPage(int p) {
        page = p;
    }

    @Given("I set user id to {int}")
    public void setUserId(int id) {
        userId = id;
    }

    @When("I request GET /users")
    public void getUsers() {
        response = UserRequest.getUsers(page);
    }

    @When("I request GET /users/{id}")
    public void getUserById() {
        response = UserRequest.getUserById(userId);
    }

    @Then("I receive status code {int}")
    public void validateStatusCode(int status) {
        response.then().statusCode(status);
    }

    @Then("response contains users list")
    public void validateUsersList() {
        response.then().body("data", not(empty()));
    }

    @Then("response page is {int}")
    public void validatePage(int expectedPage) {
        response.then().body("page", equalTo(expectedPage));
    }
}

