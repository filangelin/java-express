package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FindAverageTest extends CustomUtilsTest {

    public static Stream<Arguments> listForAverageNumberCalc() {
        return Stream.of(
                //Обычный массив:
                Arguments.of(new int[]{1, 2, 3, 4, 5}, 3.0),
                //Массив с одним элементом:
                Arguments.of(new int[]{10}, 10.0)
        );
    }

    @ParameterizedTest
    @MethodSource("listForAverageNumberCalc")
    public void userCanCalcAverage(int[] number, double expectedAverage) {
        var actualAverage = customUtils.findAverage(number);
        assertEquals(expectedAverage, actualAverage);

    }

    @Test
    public void userCatchesExceptionWithNullForAverageCalc() {
        assertThrows(NullPointerException.class, () -> customUtils.findAverage(null));
    }
}
