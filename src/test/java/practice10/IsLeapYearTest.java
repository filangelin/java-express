package practice10;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IsLeapYearTest extends CustomUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {
            //Обычные года
            2019, 2021, 2022,
            //Года, делящиеся на 100, но не на 400
            1900, 2100
    })
    public void userCanCheckYearIsNotLeap(int year) {
        var actualIsLeap = customUtils.isLeapYear(year);
        assertFalse(actualIsLeap);
    }

    @ParameterizedTest
    @ValueSource(ints = {
            //Високосные года
            2020, 2000, 1600,
            //Граничные случаи
            0, 4, 400
    })
    public void userCanCheckYearIsLeap(int year) {
        var actualIsLeap = customUtils.isLeapYear(year);
        assertTrue(actualIsLeap);
    }
}
