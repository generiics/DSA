class Solution {
    public int longestSubarray(int[] nums) {

        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {

            int zero = 0;

            for (int j = i; j < n; j++) {

                if (nums[j] == 0) {
                    zero++;
                }
                if (zero > 1) {
                    break;
                }
                ans = Math.max(ans, j - i);
            }
        }

        return ans;
    }
}