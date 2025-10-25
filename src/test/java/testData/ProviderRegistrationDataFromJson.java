package testData;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.params.provider.Arguments;

import java.io.File;
import java.io.IOException;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ProviderRegistrationDataFromJson {
    private static final String DATA_PATH = "src/test/resources/registration-data.json";
    private static final ObjectMapper mapper = new ObjectMapper();

    public static Stream<Arguments> registrationData() {
        try {
            RegistrationData[] dataArray = mapper.readValue(new File(DATA_PATH), RegistrationData[].class);
            return IntStream.range(0, dataArray.length)
                    .mapToObj(i -> Arguments.of("Case #" + (i + 1), dataArray[i]));
        } catch (IOException e) {
            throw new RuntimeException("Ошибка чтения файла: " + DATA_PATH, e);
        }
    }
}
