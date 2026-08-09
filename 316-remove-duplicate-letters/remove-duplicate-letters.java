class Solution {
    public String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        Stack<Character> st = new Stack<>();
        for (char ch : s.toCharArray()) {
            map.put(ch, map.get(ch) - 1);
            if (st.contains(ch)) {
                continue;
            }
            while (!st.isEmpty()
                    && st.peek() > ch
                    && map.get(st.peek()) > 0) {

                st.pop();
            }
            st.push(ch);
        }
        StringBuilder ans = new StringBuilder();
        for (char ch : st) {
            ans.append(ch);
        }
        return ans.toString();
    }
}