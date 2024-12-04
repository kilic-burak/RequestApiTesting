package helper;

import io.restassured.response.Response;
import org.example.models.ProductsItem;
import org.example.models.ResponseItem;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ValidatorUsers {


    public static void validateStatusCode(Response response, int expectedStatus) {
        int actualStatusCode = response.statusCode();
        BaseAssertionLogger.logAndAssert(expectedStatus,is(actualStatusCode),"Pass","Fail");

    }
    public static void validateUsers(ResponseItem actualUsers, ResponseItem expectedUsers){

        int actualId= actualUsers.getId();
//        int actualUserId=actualUsers.getUserId();
//        String actualDate = actualUsers.getDate();
//
//        for (ProductsItem productsItem:actualUsers.getProducts()){
//            int productId = productsItem.getProductId();
//            int quantity = productsItem.getQuantity();
//        }
        int expectedId= expectedUsers.getId();


        //BaseAssertionLogger.logAndAssert(actualId,expectedId,"pass","fail");

    }

}
