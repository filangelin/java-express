package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CountVowelsTest extends CustomUtilsTest {

    public static Stream<Arguments> validStrings() {
        return Stream.of(
                //Строки с гласными
                Arguments.of("hello", 2),
                Arguments.of("java", 2),
                Arguments.of("AEIOU", 5),
                //Строки без гласных
                Arguments.of("tst", 0),
                //Пустая строка
                Arguments.of("", 0)
        );
    }

    @ParameterizedTest
    @MethodSource("validStrings")
    public void userCanCountVowelsForValidStrings(String str, int expectedCount) {
        var actualCount = customUtils.countVowels(str);
        assertEquals(expectedCount, actualCount, "Кол-во гласных подсчитано неверно");
    }

    @Test
    public void userCatchesExceptionWithNull() {
        assertThrows(IllegalArgumentException.class, () -> customUtils.countVowels(null));
    }
}
