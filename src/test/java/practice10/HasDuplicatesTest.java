package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HasDuplicatesTest extends CustomUtilsTest {

    public static Stream<Arguments> listForDuplicatesCheck() {
        return Stream.of(
                //Без дубликатов:
                Arguments.of(new int[]{1, 2, 3, 4, 5}, false),
                //С дубликатами:
                Arguments.of(new int[]{1, 2, 2, 3}, true),
                //Пустой массив:
                Arguments.of(new int[]{}, false)
        );
    }

    @ParameterizedTest
    @MethodSource("listForDuplicatesCheck")
    public void userCanCheckDuplicates(int[] array, boolean expectedHasDuplicates) {
        var actualHasDuplicates = customUtils.hasDuplicates(array);
        assertEquals(expectedHasDuplicates, actualHasDuplicates, "Некорректная проверка на дубликаты");
    }
}
