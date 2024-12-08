package helper;

import io.restassured.response.Response;
import org.example.models.ProductsItem;
import org.example.models.ResponseItem;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;

public class ValidatorUsers {


    public static void validateStatusCode(Response response, int expectedStatus) {
        int actualStatusCode = response.statusCode();
        BaseAssertionLogger.logAndAssert(expectedStatus, is(actualStatusCode), "Pass", "Fail", "Status Code");

    }

    //    public static void validateProductsNotEmpty(List<ResponseItem> responseItems){
//
//        if (responseItems == null || responseItems.isEmpty()) {
//            BaseAssertionLogger.logAndAssert(false, is(true), "Fail", "Fail", "Response is null or empty");
//            return;
//        }
//
//        boolean allProductsNotEmpty = responseItems.stream()
//                .allMatch(item -> item.getProducts() != null && !item.getProducts().isEmpty());
//
//        BaseAssertionLogger.logAndAssert(allProductsNotEmpty, is(true), "Pass", "Fail", "All Products Not Empty");
//    }
    public static void validateUsers(ResponseItem actualUsers, ResponseItem expectedUsers) {

        List<Integer> actualProductId = actualUsers.getProducts()
                .stream()
                .map(ProductsItem::getProductId)
                .toList();
        List<Integer> actualQuantity = actualUsers.getProducts()
                .stream()
                .map(ProductsItem::getQuantity)
                .toList();
        List<Integer> expectedProductId = expectedUsers.getProducts()
                .stream()
                .map(ProductsItem::getProductId)
                .toList();
        List<Integer> expectedQuantity = expectedUsers.getProducts()
                .stream()
                .map(ProductsItem::getQuantity)
                .toList();

        int actualId = actualUsers.getId();
        int actualUserId = actualUsers.getUserId();
        String actualDate = actualUsers.getDate();

        int expectedId = expectedUsers.getId();
        int expectedUserId = expectedUsers.getUserId();
        String expectedDate = expectedUsers.getDate();

        BaseAssertionLogger.logAndAssert(actualId, is(expectedId), "Pass", "Fail", "ID");
        BaseAssertionLogger.logAndAssert(actualUserId, is(expectedUserId), "Pass", "Fail", "User ID");
        BaseAssertionLogger.logAndAssert(actualDate, is(expectedDate), "Pass", "Fail", "Date");

        if (actualProductId.size() == expectedProductId.size()) {

            for (int i = 0; i < actualProductId.size(); i++) {
                BaseAssertionLogger.logAndAssert(actualProductId.get(i), is(expectedProductId.get(i)), "Pass", "Fail", "ProductId " + (i + 1));
            }
        } else System.out.println("Quantity listeleri birbirlerine eşit değidir.");

        if (actualQuantity.size() == expectedQuantity.size()) {
            for (int i = 0; i < actualQuantity.size(); i++) {
                BaseAssertionLogger.logAndAssert(actualQuantity.get(i), is(expectedQuantity.get(i)), "Pass", "Fail", "Quantity " + (i + 1));
            }
        } else System.out.println("ProductId listeleri birbirlerine eşit değidir.");

    }

}
