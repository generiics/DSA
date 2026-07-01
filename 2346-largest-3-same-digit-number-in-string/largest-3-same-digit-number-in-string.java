class Solution {
    public String largestGoodInteger(String num) {

        char ans = '#';

        for (int i = 0; i <= num.length() - 3; i++) {

            char ch = num.charAt(i);

            if (ch == num.charAt(i + 1) && ch == num.charAt(i + 2)) {

                if (ch > ans) {
                    ans = ch;
                }
            }
        }

        if (ans == '#') {
            return "";
        }

        return "" + ans + ans + ans;
    }
}