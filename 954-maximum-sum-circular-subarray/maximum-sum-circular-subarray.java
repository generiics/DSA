class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total=0;
        int maxsum=nums[0];
        int currmax=0;
        int minsum=nums[0];
        int currmin=0;
        for(int i=0;i<nums.length;i++){
            total+=nums[i];
            currmax+=nums[i];
            if(currmax>maxsum){
                maxsum=currmax;
            }
            if(currmax<0){
                currmax=0;
            }
            currmin+=nums[i];
            if(currmin<minsum){
                minsum=currmin;
            }
            if(currmin>0){
                currmin=0;
            }
        }
            if(maxsum<0){
                return maxsum;
            }
        
        return Math.max(maxsum, total - minsum);

    }
}