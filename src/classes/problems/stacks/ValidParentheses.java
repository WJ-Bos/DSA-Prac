package classes.problems.stacks;

import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String brackets = "(){}(({{}}))[]";
        String brackets2 = "(){}(({{}}))[]]";
        System.out.println("Result -> " + isValidParentheses(brackets ));
        System.out.println("Result -> " + isValidParentheses(brackets2 ));
    }

    private static Boolean isValidParentheses(String s) {
       Stack<Character> stack = new Stack<>();
       Map<Character, Character> map = Map.of(
               ']','[',
               '}','{',
               ')','('
       );

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
