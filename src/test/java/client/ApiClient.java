package client;

import base.BaseTest;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class ApiClient extends BaseTest {

    private RequestSpecification spec;

    public ApiClient(RequestSpecification spec) {
        this.spec = spec;
    }

    public Response get(String endPoint){
        return given(spec)
                .when()
                .get(endPoint)
                .then()
                .extract()
                .response();
    }

    public Response post(String endPoint){

        return given(spec)
                .when()
                .post(endPoint)
                .then()
                .log().all()
                .extract()
                .response();
    }
}
