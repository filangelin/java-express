package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IsEvenTest extends CustomUtilsTest {


    public static Stream<Arguments> numbersForParityCheck() {
        return Stream.of(
                //Положительное четное
                Arguments.of(10, true),
                //Положительное нечетное
                Arguments.of(5, false),
                //Ноль
                Arguments.of(0, true),
                //Отрицательное четное
                Arguments.of(-6, true),
                //Отрицательное нечетное
                Arguments.of(-1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("numbersForParityCheck")
    public void userCanCheckNumberParity(int number, boolean expectedIsEven) {
        var actualIsEven = customUtils.isEven(number);
        assertEquals(expectedIsEven, actualIsEven, "Ожидаемая и фактическая четность числа отличаются");
    }
}
