package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindMaxTest extends CustomUtilsTest {


    public static Stream<Arguments> listForMaxElementSearch() {
        return Stream.of(
                //Обычный массив
                Arguments.of(new int[]{1, 5, 6, 7}, 7),
                //Один элемент в массиве
                Arguments.of(new int[]{1}, 1),
                //Отрицательные числа
                Arguments.of(new int[]{-3, -6}, -3)
        );
    }

    @ParameterizedTest
    @MethodSource("listForMaxElementSearch")
    public void userCanFindMaxElement(int[] list, int expectedMaxElement) {
        var actualMaxElement = customUtils.findMax(list);
        assertEquals(expectedMaxElement, actualMaxElement, "Максимальный элемент списка отличается от ожидаемого");
    }

    @Test
    public void userCatchesExceptionWhenSearchMaxElemInEmptyArray() {
        assertThrows(NoSuchElementException.class, () -> customUtils.findMax(new int[]{}));
    }
}
