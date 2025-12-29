package requests;

import io.restassured.response.Response;
import config.BaseTest;

public class UserRequest extends BaseTest {

    public Response getUser(int id) {
        return sendGet("/users/" + id);
    }

    public Response getUsersByPage(int page) {
        return sendGet("/users?page=" + page);
    }
}
