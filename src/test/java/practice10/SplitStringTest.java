package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SplitStringTest extends CustomUtilsTest {

    public static Stream<Arguments> stringsForSplit() {
        return Stream.of(
                //Обычная строка с разделителями:
                Arguments.of("Java,Python,C++", ",", new String[]{"Java", "Python", "C++"}),
                //Пустая строка с разделителем:
                Arguments.of("", ",", new String[]{""}),
                //Строка без разделителя:
                Arguments.of("word", ",", new String[]{"word"})
        );
    }

    @ParameterizedTest
    @MethodSource("stringsForSplit")
    public void userCanSplitString(String str, String delimiter, String[] expectedSplitedArray) {
        var actualSplitedArray = customUtils.splitString(str, delimiter);
        assertArrayEquals(expectedSplitedArray, actualSplitedArray, "Некорректная разбивка строк");
    }
}
