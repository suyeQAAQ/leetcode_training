class Solution {
    public int climbStairs(int n) {
        
        int[] dp = new int[n + 2];
        
        // initiate first and second stair
        dp[1] = 1;
        dp[2] = 2;
        
        if(n <= 2)  return dp[n];

        for(int i = 3; i <= n; i++) {

            dp[i] = dp[i - 1] + dp[i - 2];
        
        }
        
        return dp[n];
    }
}