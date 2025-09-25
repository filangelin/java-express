package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class IsValidPhoneNumberTest extends CustomUtilsTest {

    public static Stream<Arguments> phoneNumbersForValidation() {
        return Stream.of(
                // Корректные номера:
                Arguments.of("+1 1234567890", true),
                Arguments.of("+44 9876543210", true),
                Arguments.of("+999 1111111111", true),
                //Некорректные номера:
                Arguments.of("12345", false),
                Arguments.of("invalid", false),
                Arguments.of("+1 abcdefghij", false),
                //слишком длинный код страны
                Arguments.of("+1234 1234567890", false),
                //недостаточно цифр
                Arguments.of("+1 123", false),
                //пустая строка
                Arguments.of("12345", false)
        );
    }

    @ParameterizedTest
    @MethodSource("phoneNumbersForValidation")
    public void userCanValidatePhoneNumbers(String number, boolean expectedIsValid) {
        var actualIsValid = customUtils.isValidPhoneNumber(number);
        assertEquals(expectedIsValid, actualIsValid);
    }

    @Test
    public void userCatchesExceptionWithNullNumberValidation() {
        assertThrows(NullPointerException.class, () -> customUtils.isValidPhoneNumber(null));
    }
}
