package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FilterEvenNumbersTest extends CustomUtilsTest {

    public static Stream<Arguments> listForFilterEvenNumbers() {
        return Stream.of(
                //Обычный список
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), List.of(2, 4, 6)),
                //Список без чётных чисел:
                Arguments.of(List.of(1, 3, 5), List.of()),
                //Отрицательные числа
                Arguments.of(List.of(), List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("listForFilterEvenNumbers")
    public void userCanFilterEvenNumbers(List<Integer> list, List<Integer> expectedList) {
        var actualList = customUtils.filterEvenNumbers(list);
        assertEquals(expectedList, actualList, "Некорректная фильтрация четных чисел");
    }
}
