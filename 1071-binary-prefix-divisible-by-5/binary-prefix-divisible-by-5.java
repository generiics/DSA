class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {

        List<Boolean> ans = new ArrayList<>();
        int rem = 0;
        for (int num : nums) {
            rem = (rem * 2 + num) % 5;

            if (rem == 0) {
                ans.add(true);
            } else {
                ans.add(false);
            }
        }

        return ans;
    }
}