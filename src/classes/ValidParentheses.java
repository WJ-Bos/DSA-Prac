package classes;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String brackets = "(){}(({{}}))[]";
        String brackets2 = "(){}(({{}}))[]";
        System.out.println("Result -> " + isValidParentheses(brackets ));
        System.out.println("Result -> " + isValidParentheses(brackets2 ));
    }

    private static Boolean isValidParentheses(String s) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.peek() != map.get(c)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
