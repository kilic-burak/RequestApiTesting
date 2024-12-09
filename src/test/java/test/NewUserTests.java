package test;

import base.BaseTest;
import client.ApiClient;
import helper.ValidatorUsers;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

public class NewUserTests extends BaseTest {
    @Test
    public void newUserTest(){

        JSONObject body = new JSONObject();
        body.put("title", "test product");
        body.put("price", 13.5);
        body.put("description", "lorem ipsum set");
        body.put("image", "https://i.pravatar.cc");
        body.put("category", "electronic");

        ApiClient apiClient = createApiClient();
        Response response = apiClient.post("products",body.toString());

        ValidatorUsers.validateStatusCode(response,201);

        apiClient.get("products");




    }
}
