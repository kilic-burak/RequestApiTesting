package helper;

import io.restassured.response.Response;
import org.example.models.ProductsItem;
import org.example.models.ResponseItem;

import static org.hamcrest.Matchers.is;

public class ValidatorUsers {


    public static void validateStatusCode(Response response, int expectedStatus) {
        int actualStatusCode = response.statusCode();
        BaseAssertionLogger.logAndAssert(expectedStatus,is(actualStatusCode),"Pass","Fail","Status Code");

    }
    public static void validateUsers(ResponseItem actualUsers, ResponseItem expectedUsers){

        int actualId= actualUsers.getId();
        int actualUserId=actualUsers.getUserId();
        String actualDate = actualUsers.getDate();

        for (ProductsItem productsItem:actualUsers.getProducts()){
            int actualProductId = productsItem.getProductId();
            int actualQuantity = productsItem.getQuantity();
        }


        int expectedId= expectedUsers.getId();
        int expectedUserId= expectedUsers.getUserId();
        String expectedDate =expectedUsers.getDate();

        for (ProductsItem productsItem:expectedUsers.getProducts()){
            int expectedProductId = productsItem.getProductId();
            int expectedQuantity = productsItem.getQuantity();
        }

        BaseAssertionLogger.logAndAssert(expectedId,is(actualId),"Pass","Fail","ID");
        BaseAssertionLogger.logAndAssert(expectedUserId,is(actualUserId),"Pass","Fail","User ID");
        BaseAssertionLogger.logAndAssert(expectedDate,is(actualDate),"Pass","Fail","Date");
        //BaseAssertionLogger.logAndAssert(expectedProductId,is(actualProductId),"Pass","Fail","Date");

    }

}
