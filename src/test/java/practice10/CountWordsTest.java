package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountWordsTest extends CustomUtilsTest {

    public static Stream<Arguments> validStringsForWordsCounting() {
        return Stream.of(
                //    Обычная строка:
                Arguments.of("Hello world", 2),
                //    Строка с лишними пробелами:
                Arguments.of(" Java is awesome ", 3),
                //    Пустая строка: ""
                Arguments.of("", 0),
                //    Строка с пробелами:
                Arguments.of(" ", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("validStringsForWordsCounting")
    public void userCanCountWordsWithValidStrings(String str, int expectedWordCount) {
        var actualWordCount = customUtils.countWords(str);
        assertEquals(expectedWordCount, actualWordCount);
    }

    @Test
    public void userCatchesExceptionWithNull() {
        assertThrows(NullPointerException.class, () -> customUtils.countWords(null));
    }
}
