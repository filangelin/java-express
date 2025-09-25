package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsValidPasswordTest extends CustomUtilsTest {

    public static Stream<Arguments> passwordsForValidation() {
        return Stream.of(
                //Корректный пароль:
                Arguments.of("Password1", true),
                //Пароль, который слишком короткий:
                Arguments.of("pass", false),
                //Пароль с отсутствием цифры или заглавной буквы:
                Arguments.of("password", false),
                //Null пароль:
                Arguments.of(null, false)
        );
    }

    @ParameterizedTest
    @MethodSource("passwordsForValidation")
    public void userCanValidatePassword(String password, boolean expectedIsValid) {
        var actualIsValid = customUtils.isValidPassword(password);
        assertEquals(expectedIsValid, actualIsValid);
    }
}
