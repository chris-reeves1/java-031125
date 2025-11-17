import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
//import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import Rtesting.Calculator;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class CalcTest {
    private final Calculator calc = new Calculator();
    //alternative: 
//     Calculator calc1;

//     @BeforeAll
//     void init(){calc1 = new Calculator();}

//     @AfterAll
//     void teardown(){calc1 =null;}

//     @BeforeEach

//     @AfterEach
// }


    @Test
    @DisplayName("Add: sums two ints (happy path)")
    void add_basic(){
        // arrange and act
        int result = calc.add(2, 3);
        // Assert
        assertEquals(5, result);
    }

    @ParameterizedTest // mainly primitive types
    @ValueSource(ints = {0, 1, -1})
    void add_with_zero_one_minus_one(int x){
        assertEquals(x, calc.add(x, 0));
    }

    @ParameterizedTest(name = "add({0}, {1}) = {2}")
    @CsvSource({"0, 0, 0",
                "1, 0, 1",
                "-1, 1, 0",
                "100, 200, 300"                    
})
void add_table(int a, int b, int expected){
    assertEquals(expected, calc.add(a, b));
}

@Test
void divsion_throws_its_error(){
    IllegalArgumentException x = assertThrows(IllegalArgumentException.class, () -> calc.div(10, 0));
    assertEquals("b must not be zero", x.getMessage());
}


@Nested
class ClampTests{

    @Test
    void clamp_is_less_than_min(){
        assertEquals(10, calc.clamp(10, 5, 20));
    }

    @Test
    void itthrowws(){
        assertThrows(IllegalArgumentException.class, () -> calc.clamp(10, 30, 20));
    }

    @Test
    void multiple_asserts(){
        assertAll(
            () -> assertEquals(10, calc.clamp(5, 10, 20)),
            () -> assertEquals(10, calc.clamp(5, 10, 30))
        );
    }
}















}