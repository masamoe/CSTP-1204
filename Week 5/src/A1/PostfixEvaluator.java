package A1;

import java.util.Stack;

/**
 *
 *
 * This class contains a method to evaluate an arithmetic expression
 * that is in Postfix notation (or Reverse Polish Notation).
 * See
 * <a href="https://en.wikipedia.org/wiki/Reverse_Polish_notation">Wikipedia</a>
 * for details on the notation.
 *
 */
public class PostfixEvaluator {

    private String arithmeticExpr;

    /**
     * This is the only constructor for this class.
     * It takes a string that represents an arithmetic expression
     * as input argument.
     *
     * @param expr is a string that represents an arithmetic expression
     *             <strong>in Postfix notation</strong>.
     */
    public PostfixEvaluator(String expr) {
        arithmeticExpr = expr;

    }

    /**
     * This method evaluates the arithmetic expression that
     * was passed as a string to the constructor for this class.
     *
     * @return the value of the arithmetic expression
     * @throws MalformedExpressionException if the provided expression is not
     *                                      a valid expression in Postfix notation
     */
    double eval() throws MalformedExpressionException {
        Scanner scanner = new Scanner(arithmeticExpr);
        Stack<Double> tokenStack = new Stack<Double>();

        while (!scanner.isEmpty()) {
            Token currToken = scanner.getToken();
            System.out.println(currToken.toString());

            if (currToken.isDouble()) {
                tokenStack.push(currToken.getValue());
            } else {
                if (tokenStack.size() < 2) {
                    throw new MalformedExpressionException("Not enough operands");
                }
                double operand2 = tokenStack.pop();
                double operand1 = tokenStack.pop();
                double result = 0;
                switch (currToken.getName()) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                    case "*":
                        result = operand1 * operand2;
                        break;
                    case "/":
                        result = operand1 / operand2;
                        break;
                    default:
                        throw new MalformedExpressionException("Invalid operator");
                }
                tokenStack.push(result);
            }
            scanner.eatToken();
        }

        System.out.println(tokenStack.peek());
        // now process the token, etc.
        // You should read the implementation of the Token class
        // to determine what methods you can and should use.

        // It is sufficient to support the four basic operations:
        // addition, subtraction, multiplication & division.

        return tokenStack.peek();
    }
}
