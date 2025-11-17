import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Assertions.*;

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








}