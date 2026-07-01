class Solution {
    public int countPalindromicSubsequence(String s) {

        int ans = 0;

        for (char ch = 'a'; ch <= 'z'; ch++) {

            int first = -1;
            int last = -1;
            for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {

                    if (first == -1) {
                        first = i;
                    }
                    last = i;
                }
            }
            if (first == -1 || first == last) continue;

            HashSet<Character> set = new HashSet<>();

            for (int i = first + 1; i < last; i++) {
                set.add(s.charAt(i));
            }

            ans += set.size();
        }

        return ans;
    }
}