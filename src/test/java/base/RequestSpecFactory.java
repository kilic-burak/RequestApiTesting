package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;

import java.util.Arrays;

public class RequestSpecFactory {

    public static RequestSpecification getDefaultSpec(){
        return new RequestSpecBuilder()
                .setBaseUri("https://fakestoreapi.com/")
                .addFilters(Arrays.asList(new RequestLoggingFilter(), new ResponseLoggingFilter()))
                .build();
    }
}
