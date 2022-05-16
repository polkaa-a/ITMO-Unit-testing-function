import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class TaylorSeriesTest {

    @ParameterizedTest
    @CsvSource(value = {
            "0, 1",
            "0.22, 1.024698",
            "-0.22, 1.024698",
            "0.56, 1.180282",
            "-0.56, 1.180282",
            "1, 1.850816",
            "-1, 1.850816",
            "1.34, 4.371531",
            "-1.34, 4.371531",
            "1.56, 92.625895",
            "-1.56, 92.625895",
            "3.14, -1.000001",
            "3.36, -1.024334",
            "2.92, -1.025064",
            "4.14, -1.846239",
            "2.14, -1.855420",
            "4.48, -4.342107",
            "1.80, -4.401368",
            "4.70, -80.718958",
            "1.58, -108.653805"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void secValidBoundaryInputs(double a, double expected) throws FunctionIrrelevantException {
        double result = TaylorSeries.sec(a);
        assertEquals(expected, result, 0.01, "Result: " + result + "\nExpected value: " + expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0.1, 1.00502",
            "-0.1, 1.00502",
            "-0.4, 1.085704",
            "0.4, 1.085704",
            "-0.66, 1.265835",
            "0.66, 1.265835",
            "-1.2, 2.759704",
            "1.2, 2.759704",
            "-1.45, 8.298564",
            "1.45, 8.298564",
            "3.24, -1.004862",
            "3.04, -1.005183",
            "2.74, -1.086437",
            "3.80, -1.264274",
            "2.48, -1.267403",
            "4.34, -2.748448",
            "1.94, -2.771059",
            "4.59, -8.191104",
            "1.69, -8.4089034"
    }, ignoreLeadingAndTrailingWhitespace = true)
    void secValidInputs(double a, double expected) throws FunctionIrrelevantException {
        double result = TaylorSeries.sec(a);
        assertEquals(expected, result, 0.01, "Result: " + result + "\nExpected result: " + expected);
    }

    @ParameterizedTest
    @ValueSource(doubles = {
            1.5707963267948965,
            -1.5707963267948965,
            4.71238898038469
    })
    void secInvalidInputs(double a) {
        String expectedLog = "Function value is irrelevant in point " + a;
        TaylorSeries.setAddendumNum(12);
        FunctionIrrelevantException thrown = assertThrows(
                FunctionIrrelevantException.class,
                () -> TaylorSeries.sec(a)
        );
        assertTrue(thrown.getMessage().contains(expectedLog));
    }

    @ParameterizedTest
    @ValueSource(ints = {
            -1,
            -8,
            -112
    })
    void setAddendumNumInvalidInputs(int a) {
        TaylorSeries.setAddendumNum(a);
        Assertions.assertEquals(11, TaylorSeries.getAddendumNum());
    }

    @ParameterizedTest
    @ValueSource(ints = {
            0,
            5,
            10
    })
    void setAddendumNumValidInputs(int a) {
        TaylorSeries.setAddendumNum(a);
        Assertions.assertEquals(a, TaylorSeries.getAddendumNum());
    }
}


