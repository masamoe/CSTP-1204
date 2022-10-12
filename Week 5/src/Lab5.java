import java.util.Stack;


public class Lab5 {
    static boolean contains(char c, char[] array) {
        for (char x : array) {
            if (x == c) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String input = "()[]{}";
        Stack<Character> myStack = new Stack<>();
        boolean result;
        for (char x: input.toCharArray()) {
            char[] starters = new char[]{'(', '[', '{'};
            char[] enders = new char[]{')', ']', '}'};
            if (contains(x, starters)){
                myStack.push(x);
            }
            if (contains(x, enders)){
                char comparator = myStack.pop();
                if (x == ')'){
                    if (comparator == '('){
                        result = true;
                    }
                    else {
                        result = false;
                        return;
                    }
                }
                if (x == ']'){
                    if (comparator == '['){
                        result = true;
                    }
                    else {
                        result = false;
                        return;
                    }
                }
                if (x == '}'){
                    if (comparator == '{'){
                        result = true;
                    }
                    else {
                        result = false;
                        return;
                    }
                }
            }
        }
    }
}
