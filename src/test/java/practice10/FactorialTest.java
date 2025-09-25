package practice10;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest extends CustomUtilsTest {

    public static Stream<Arguments> numbersForFactorialCalculation() {
        return Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(2, 2),
                Arguments.of(5, 120)

        );
    }

    @ParameterizedTest
    @MethodSource("numbersForFactorialCalculation")
    public void userCanCalcFactorial(int number, int expectedFactorial) {
        var actualFactorial = customUtils.factorial(number);
        assertEquals(expectedFactorial, actualFactorial);

    }

    @Test
    public void userCatchesExceptionWithNegativeNumberForFactorial() {
        assertThrows(IllegalArgumentException.class, () -> customUtils.factorial(-7));
    }
}
