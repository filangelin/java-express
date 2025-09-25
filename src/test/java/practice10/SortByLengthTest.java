package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SortByLengthTest extends CustomUtilsTest {

    public static Stream<Arguments> listForSortByLength() {
        return Stream.of(
                //Обычный список
                Arguments.of(List.of("Java", "C", "Python"), List.of("C", "Java", "Python")),
                //Список с одинаковыми длинами
                Arguments.of(List.of("aa", "bb", "cc"), List.of("aa", "bb", "cc")),
                //Пустой список
                Arguments.of(List.of(), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("listForSortByLength")
    public void userCanSortStringsByLength(List<String> list, List<String> expectedList) {
        var actualList = customUtils.sortByLength(list);
        assertEquals(expectedList, actualList, "Некорректная сортировка строк по длине");
    }
}
