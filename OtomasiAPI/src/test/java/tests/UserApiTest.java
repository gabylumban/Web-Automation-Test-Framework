package tests;

import config.BaseTest;
import requests.UserRequest;
import utils.TestDataUtil;   // <--- pastikan ini ada
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.given;

public class UserApiTest extends BaseTest {
    ...
}
