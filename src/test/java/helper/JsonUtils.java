package helper;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.models.ResponseItem;

import java.io.IOException;
import java.io.InputStream;

public class JsonUtils {
    public static ResponseItem readTestDataFromJsonFile(String fileName) {
        try {

            InputStream inputStream = JsonUtils.class.getClassLoader().getResourceAsStream(fileName);


            if (inputStream == null) {
                System.out.println("File not found: " + fileName);
                return null;
            }

            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(inputStream, ResponseItem.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
