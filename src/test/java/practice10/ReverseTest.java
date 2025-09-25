package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ReverseTest extends CustomUtilsTest {

    public static Stream<Arguments> stringsToReverse() {
        return Stream.of(
                //Обычное слово
                Arguments.of("test", "tset"),
                //Слово с разным регистром
                Arguments.of("Word", "droW"),
                //Один символ
                Arguments.of("t", "t"),
                //Пустая строка
                Arguments.of("", ""),
                //null
                Arguments.of(null, null)
        );
    }

    @ParameterizedTest
    @MethodSource("stringsToReverse")
    public void userCanReverseValidString(String input, String expectedReversedString) {
        var actualReversedStrings = customUtils.reverse(input);
        assertEquals(expectedReversedString, actualReversedStrings, "Перевернутая строка отличается от ожидаемой");
    }
}
