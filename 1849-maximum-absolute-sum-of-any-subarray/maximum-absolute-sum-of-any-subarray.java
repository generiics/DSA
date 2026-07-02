class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int prefix=0;
        int maxprefix=0;
        int minprefix=0;
        for(int num:nums){
            prefix+=num;
            maxprefix=Math.max(maxprefix,prefix);
            minprefix=Math.min(minprefix,prefix);
        }
        return maxprefix-minprefix;
        
    }
}