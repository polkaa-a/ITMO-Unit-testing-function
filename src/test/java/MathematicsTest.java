import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class MathematicsTest {

    @ParameterizedTest
    @CsvSource(value = {
            "5, 120",
            "8, 40320",
            "11, 39916800"
    })
    void validInputs(int a, long expected) throws FactorialOverflowException {
        double result = Mathematics.factorial(a);
        assertEquals(expected, result, 0.01, "Result: " + result + "\nExpected value: " + expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "0, 1",
            "20, 2432902008176640000"
    })
    void validBoundaryInputs(int a, long expected) throws FactorialOverflowException {
        double result = Mathematics.factorial(a);
        assertEquals(expected, result, 0.01, "Result: " + result + "\nExpected value: " + expected);
    }

    @ParameterizedTest
    @CsvSource(value = {
            "-1, 1",
            "-12, 1"
    })
    void invalidInputs(int a, long expected) throws FactorialOverflowException {
        double result = Mathematics.factorial(a);
        assertEquals(expected, result, 0.01, "Result: " + result + "\nExpected value: " + expected);
    }

    @Test
    public void factorialOverflowNotificationAppear() throws FunctionIrrelevantException {
        String expectedLog = "Decrease in calculation accuracy occurred";
        FactorialOverflowException thrown = assertThrows(
                FactorialOverflowException.class,
                () -> Mathematics.factorial(21)
        );
        assertTrue(thrown.getMessage().contains(expectedLog));
    }

    @Test
    public void factorialOverflowNotificationNotAppearOnBoundaryInput() {
        assertDoesNotThrow(() -> Mathematics.factorial(20));
    }
}
