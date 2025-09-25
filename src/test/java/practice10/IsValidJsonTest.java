package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsValidJsonTest extends CustomUtilsTest {

    public static Stream<Arguments> jsonForValidation() {
        return Stream.of(
                //Корректный JSON:
                Arguments.of("{\"key\":\"value\"}", true),
                //Некорректный JSON:
                Arguments.of("invalid json", false),
                //null:
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("jsonForValidation")
    public void userCanValidateJson(String json, boolean expectedIsValid) {
        var actualIsValid = customUtils.isValidJson(json);
        assertEquals(expectedIsValid, actualIsValid);
    }
}
