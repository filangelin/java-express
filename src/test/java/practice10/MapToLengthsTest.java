package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapToLengthsTest extends CustomUtilsTest {

    public static Stream<Arguments> listForMapToLength() {
        return Stream.of(
                //Обычный список
                Arguments.of(List.of("Java", "C++", "Go"), List.of(4, 3, 2)),
                //Пустой список
                Arguments.of(List.of(), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("listForMapToLength")
    public void userCanMapWordsToLength(List<String> list, List<Integer> expectedList) {
        var actualList = customUtils.mapToLengths(list);
        assertEquals(expectedList, actualList, "Некорректный маппинг слов к их длине");
    }
}
