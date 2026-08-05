class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int leftMax=0;
        int rightMax=0;
        int ans=0;

        while(left<right){
            if(height[left]<height[right]){
                if(leftMax>height[left]){
                    ans+=leftMax-height[left];
                }else{
                    leftMax=height[left];
                }
                left++;
            }
            else{
                if(rightMax>height[right]){
                    ans+=rightMax-height[right];
                }else{
                    rightMax=height[right];
                }
                right--;
            }
        }
        return ans;

    }
}