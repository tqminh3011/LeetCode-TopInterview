import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

// Examples
// ()
// ()[]{} -> true
// (]
// ()[]{
// {[]} -> true
// ]
public class ValidParentheses {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String input  = bufferedReader.readLine();

        long start = System.currentTimeMillis();
        boolean result = isValid(input);
        System.out.format("Executed in %sms\n", (System.currentTimeMillis() - start));

        System.out.format("Result=%s \n", result);
    }

    // Own solution, beats 73% in time
    public static boolean isValid(String s) {
        try {
            Stack<Character> remaining = new Stack<>();
            Set<Character> openings = Set.of('(', '[', '{'); // SHOULD NOT CONSTRUCT SET IN EVERY ITERATION

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == ')' && '(' != (remaining.pop())) {
                    return false;
                }

                if (c == ']' && '[' != (remaining.pop())) {
                    return false;
                }

                if (c == '}' && '{' != (remaining.pop())) {
                    return false;
                }

                if (openings.contains(c)) {
                    remaining.push(c);
                }
            }

            return remaining.isEmpty();
        } catch (Exception e) {
            return false;
        }
    }

    // Online solution, beats 73% in time
    public static boolean onlineIsValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(')
                stack.push(')');
            else if (c == '{')
                stack.push('}');
            else if (c == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != c)
                return false;
        }
        return stack.isEmpty();
    }

}