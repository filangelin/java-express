package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsValidEmailTest extends CustomUtilsTest {

    @ParameterizedTest
    @ValueSource(strings = {
            //Корректные email
            "test@example.com", "user.name@domain.co", "a@b.cc"
    })
    public void userCanValidateValidEmail(String email) {
        var actualIsValidEmail = customUtils.isValidEmail(email);
        assertTrue(actualIsValidEmail);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            //Некорректные email
            "bad@.com", "no-at-symbol", "@missing-user.com", "user@domain",
            //Пустая строка:
            "",
            //null:
    })
    public void userCanNotValidateInvalidEmail(String email) {
        var actualIsValidEmail = customUtils.isValidEmail(email);
        assertFalse(actualIsValidEmail);
    }

    @Test
    public void userCanNotValidateNull() {
        var actualIsValidEmail = customUtils.isValidEmail(null);
        assertFalse(actualIsValidEmail);
    }
}
