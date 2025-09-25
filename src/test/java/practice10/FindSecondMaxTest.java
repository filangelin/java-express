package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.NoSuchElementException;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindSecondMaxTest extends CustomUtilsTest {

    public static Stream<Arguments> listForSecondMaxElementSearch() {
        return Stream.of(
                Arguments.of(new int[]{1, 5, 6, 7}, 6)
        );
    }

    public static Stream<Object> invalidListForSecondMaxElementSearch() {
        return Stream.of(
                // Массив с одинаковыми числами
                Arguments.of(new int[]{1, 1, 1, 1}, NoSuchElementException.class),
                //Один элемент
                Arguments.of(new int[]{5}, IllegalArgumentException.class),
                //Пустой массив
                Arguments.of(new int[]{}, IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @MethodSource("listForSecondMaxElementSearch")
    public void userCanFindSecondMaxInValidArray(int[] array, int expectedSecondMaxElem) {
        var actualSecondMaxElem = customUtils.findSecondMax(array);
        assertEquals(expectedSecondMaxElem, actualSecondMaxElem);
    }

    @ParameterizedTest
    @MethodSource("invalidListForSecondMaxElementSearch")
    public void userCatchesExceptionWithInvalidArrayForSecondMaxSearch(int[] array, Class<Throwable> exception) {
        assertThrows(exception, () -> customUtils.findSecondMax(array));
    }
}
