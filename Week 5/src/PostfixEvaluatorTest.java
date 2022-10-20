import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PostfixEvaluatorTest {

    // Implement a sufficient number of tests to have
    // reasonable confidence in the correctness of your
    // PostfixEvaluator implementation.

    @Test
    public void test() {
        eval("9 9 +");
        eval("+99");

        //fail("Not yet implemented");
    }

}