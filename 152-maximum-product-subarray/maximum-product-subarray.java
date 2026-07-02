class Solution {
    public int maxProduct(int[] nums) {

        int currMax = nums[0];
        int currMin = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            int oldMax = currMax;
            currMax = Math.max(num,
                    Math.max(oldMax * num, currMin * num));

            currMin = Math.min(num,
                    Math.min(oldMax * num, currMin * num));

            ans = Math.max(ans, currMax);
        }

        return ans;
    }
}