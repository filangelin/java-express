package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsAnagramTest extends CustomUtilsTest {

    public static Stream<Arguments> wordsForCheckIsAnagram() {
        return Stream.of(
                //Анаграммы:
                Arguments.of("listen", "silent", true),
                //Не анаграммы:
                Arguments.of("java", "python", false),
                //null
                Arguments.of(null, "word", false)
        );
    }

    @ParameterizedTest
    @MethodSource("wordsForCheckIsAnagram")
    public void userCanCheckIsWordAnagram(String str1, String str2, boolean expectedIsAnagram) {
        var actualIsAnagram = customUtils.isAnagram(str1, str2);
        assertEquals(expectedIsAnagram, actualIsAnagram, "Некорректный результат сравнения слов на анаграммы");
    }
}
