class Solution {
    public int maxSum(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        int sum = 0;
        int max = nums[0];

        for (int num : nums) {

            max = Math.max(max, num);

            if (num > 0 && !set.contains(num)) {
                set.add(num);
                sum += num;
            }
        }

        if (sum > 0) {
            return sum;
        }

        return max;
    }
}