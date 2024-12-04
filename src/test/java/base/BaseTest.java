package base;

import client.ApiClient;
import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.BeforeEach;


public class BaseTest {

    protected RequestSpecification spec;
    @BeforeEach
    public void setup(){
        spec = RequestSpecFactory.getDefaultSpec();
    }
    public ApiClient createApiClient() {
        return new ApiClient(spec);
    }

}
