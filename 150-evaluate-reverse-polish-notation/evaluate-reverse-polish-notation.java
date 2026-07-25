import java.util.Stack;
import java.util.HashMap;
import java.util.function.BiFunction;

class Solution {

    public int evalRPN(String[] tokens) {

        Stack<Integer> st = new Stack<>();

        HashMap<String, BiFunction<Integer, Integer, Integer>> mp = new HashMap<>();

        mp.put("+", (a, b) -> a + b);
        mp.put("-", (a, b) -> a - b);
        mp.put("*", (a, b) -> a * b);
        mp.put("/", (a, b) -> a / b);

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")) {

                // Top 2 elements pop karke operation karo
                int b = st.pop();
                int a = st.pop();

                int result = mp.get(token).apply(a, b);

                st.push(result);

            } else {

                st.push(Integer.parseInt(token));
            }
        }

        return st.peek();
    }
}