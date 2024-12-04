package test;

import base.BaseTest;
import client.ApiClient;
import helper.ValidatorUsers;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class ListUsersTests extends BaseTest {

    @Test
    public void ListUsers(){

        ApiClient apiClient = createApiClient();
        Response response = apiClient.get("carts");
        ValidatorUsers.validateStatusCode(response,200);

    }
}
