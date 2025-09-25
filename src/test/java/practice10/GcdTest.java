package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GcdTest extends CustomUtilsTest {

    public static Stream<Arguments> numbersForGcdCalc() {
        return Stream.of(
                //Обычные числа:
                Arguments.of(24, 36, 12),
                //Простые числа:
                Arguments.of(101, 103, 1),
                //Нулевое значение:
                Arguments.of(0, 10, 10)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersForGcdCalc")
    public void userCanCalculateGcd(int number1, int number2, int expectedGcd) {
        var actualGcd = customUtils.gcd(number1, number2);
        assertEquals(expectedGcd, actualGcd, "Некорректное вычисление НОД");
    }
}
