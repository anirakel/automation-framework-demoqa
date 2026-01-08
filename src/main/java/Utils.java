import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Utils {
    private static final ObjectMapper mapper = new ObjectMapper();

    // Generic method, կարող է ցանկացած class deserialize անել
    public static <T> T fromJson(String path, Class<T> clazz) {
        try {
            return mapper.readValue(new File(path), clazz);
        } catch (Exception e) {
            throw new RuntimeException("Failed to read JSON file: " + path, e);
        }
    }

    public static <T> List<T> fromJsonList(String path) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(
                    new File(path),
                    new TypeReference<List<T>>() {}
            );
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file", e);
        }
    }


}
