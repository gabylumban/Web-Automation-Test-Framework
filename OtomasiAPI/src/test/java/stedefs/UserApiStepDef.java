package stedefs;

import config.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;
import requests.UserRequest;

public class UserApiStepDef extends BaseTest {

    Response response;
    UserRequest userRequest = new UserRequest();

    @Given("user service is available")
    public void user_service_is_available() {
        // setup sudah di BaseTest
    }

    @When("user sends request get user")
    public void user_sends_request_get_user() {
        response = userRequest.getUser();
    }

    @Then("response status code should be {int}")
    public void response_status_code_should_be(Integer statusCode) {
        Assert.assertEquals(statusCode.intValue(), response.getStatusCode());
    }
}
