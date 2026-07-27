class Solution {
    public int maxSum(int[] nums) {
        int[] best = new int[10];
        int ans = -1;
        for (int num : nums) {
            int digit = maxDigit(num);

            if (best[digit] != 0) {
                ans = Math.max(ans, best[digit] + num);
            }
            best[digit] = Math.max(best[digit], num);
        }
        return ans;
    }

    private int maxDigit(int num) {
        int max = 0;
        while (num > 0) {
            max = Math.max(max, num % 10);
            num /= 10;
        }
        return max;
    }
}