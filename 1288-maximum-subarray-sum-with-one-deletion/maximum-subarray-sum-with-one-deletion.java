class Solution {
    public int maximumSum(int[] arr) {
        int ans=arr[0];
        int delete=0;
        int keep=arr[0];

        for(int i=1;i<arr.length;i++){
            int prevkeep=keep;
            keep=Math.max(keep+arr[i],arr[i]);
            delete=Math.max(delete+arr[i],prevkeep);
        
        ans=Math.max(ans,Math.max(keep,delete));
        }
        return ans;

        
    }
}