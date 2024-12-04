package test;

import base.BaseTest;
import client.ApiClient;
import helper.JsonUtils;
import helper.ValidatorUsers;
import io.restassured.response.Response;
import org.example.models.ResponseItem;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ListUsersTests extends BaseTest {

    @Test
    public void ListUsers(){

        ApiClient apiClient = createApiClient();
        Response response = apiClient.get("carts");
        ValidatorUsers.validateStatusCode(response,200);
    }

    @Test
    public void userTest(){

        ApiClient apiClient = createApiClient();
        Response response = apiClient.get("carts/1");
        ResponseItem actualResponse = response.as(ResponseItem.class);
        ResponseItem expectedResponse = JsonUtils.readTestDataFromJsonFile("users.json");
        ValidatorUsers.validateStatusCode(response,200);
        System.out.println(actualResponse.getId());
        System.out.println(actualResponse.getUserId());
        System.out.println(actualResponse.getProducts());

        ValidatorUsers.validateUsers(actualResponse,expectedResponse);



    }
}
