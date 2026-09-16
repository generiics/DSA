class Solution {
    int[] dp;
    public int fib(int n) {
        dp=new int[n+1];
        for(int i=2;i<=n;i++){
            dp[i]=-1;
        }
        return solve(n);
    }
    public int solve(int n){
         if(n<=1) return n;
         if(dp[n]!=-1){
            return dp[n];
         }
         dp[n]=solve(n-1)+solve(n-2);
         return dp[n];
    }
}