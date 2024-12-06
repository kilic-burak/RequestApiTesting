package helper;

import io.restassured.response.Response;
import org.example.models.ProductsItem;
import org.example.models.ResponseItem;

import java.util.ArrayList;

import static org.hamcrest.Matchers.is;

public class ValidatorUsers {


    public static void validateStatusCode(Response response, int expectedStatus) {
        int actualStatusCode = response.statusCode();
        BaseAssertionLogger.logAndAssert(expectedStatus,is(actualStatusCode),"Pass","Fail","Status Code");

    }
    public static void validateUsers(ResponseItem actualUsers, ResponseItem expectedUsers){

        ArrayList<Integer> actualProductId = new ArrayList<>();
        ArrayList<Integer> actualQuantity=new ArrayList<>();
        int actualId= actualUsers.getId();
        int actualUserId=actualUsers.getUserId();
        String actualDate = actualUsers.getDate();

        for (ProductsItem productsItem:actualUsers.getProducts()){
            actualProductId.add(productsItem.getProductId());
            actualQuantity.add(productsItem.getQuantity());

        }

        ArrayList<Integer> expectedProductId = new ArrayList<>();
        ArrayList<Integer> expectedQuantity=new ArrayList<>();
        int expectedId= expectedUsers.getId();
        int expectedUserId= expectedUsers.getUserId();
        String expectedDate =expectedUsers.getDate();

        for (ProductsItem productsItem:expectedUsers.getProducts()){
            expectedProductId.add(productsItem.getProductId());
            expectedQuantity.add(productsItem.getQuantity());
        }

        BaseAssertionLogger.logAndAssert(actualId,is(expectedId),"Pass","Fail","ID");
        BaseAssertionLogger.logAndAssert(actualUserId,is(expectedUserId),"Pass","Fail","User ID");
        BaseAssertionLogger.logAndAssert(actualDate,is(expectedDate),"Pass","Fail","Date");

        if (actualProductId.size()==expectedProductId.size()) {
            for (int i = 0; i < actualProductId.size(); i++) {
                BaseAssertionLogger.logAndAssert(actualProductId.get(i),is(expectedProductId.get(i)),"Pass","Fail","ProductId "+(i+1));
            }
        }
        else System.out.println("Quantity listeleri birbirlerine eşit değidir.");

        if (actualQuantity.size()==expectedQuantity.size()) {
            for (int i = 0; i < actualQuantity.size(); i++) {
                BaseAssertionLogger.logAndAssert(actualQuantity.get(i),is(expectedQuantity.get(i)),"Pass","Fail","Quantity "+(i+1));
            }
        }
        else System.out.println("ProductId listeleri birbirlerine eşit değidir.");



    }

}
