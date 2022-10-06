import java.util.Stack;

public class Lab5 {
    public static void main(String[] args) {
        String input = "()[]{}";
        Stack<Character> myStack = new Stack<>();
        boolean result;
        for (char x: input.toCharArray()) {
            char[] starters = new char[]{'(', '[', '{'};
            char[] enders = new char[]{')', ']', '}'};
            if (starters.contains(x)){
                myStack.push(x);
            }
            if (enders.contains(x)){
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
