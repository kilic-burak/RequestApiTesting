package helper;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


public class ValidatorUsers {


    public static void validateStatusCode(Response response, int expectedStatus) {
        int actualStatusCode = response.statusCode();
        assertThat("\nExpected Status Code: "+expectedStatus + "\nActual Status Code: "+actualStatusCode,expectedStatus, is(actualStatusCode));
    }

}
