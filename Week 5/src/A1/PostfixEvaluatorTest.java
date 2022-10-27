package A1;

import static org.junit.Assert.*;

import org.junit.Test;

public class PostfixEvaluatorTest {

    // Implement a sufficient number of tests to have
    // reasonable confidence in the correctness of your
    // PostfixEvaluator implementation.

    @Test
    public void test() {
        PostfixEvaluator eval = new PostfixEvaluator("9 9 +");
        try {
            assertEquals(18, eval.eval(), 0); // 18
        } catch (MalformedExpressionException e) {
            fail("This black shoudn't execute.");
        }
    }
}