class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {

            if (!st.isEmpty() &&
                Character.toLowerCase(st.peek()) == Character.toLowerCase(ch) &&
                st.peek() != ch) {

                st.pop();
            }
            else {
                st.push(ch);
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}