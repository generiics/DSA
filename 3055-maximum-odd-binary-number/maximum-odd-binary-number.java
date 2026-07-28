class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        int zeros = 0;
        for (char ch : s.toCharArray()) {
            if (ch == '1') {
                ones++;
            } else {
                zeros++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < ones - 1; i++) {
            ans.append('1');
        }
        for (int i = 0; i < zeros; i++) {
            ans.append('0');
        }
        ans.append('1');
        return ans.toString();
    }
}