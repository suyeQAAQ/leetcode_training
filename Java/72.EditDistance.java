class Solution {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();
        
        if(n == 0 || m == 0)    return Math.max(n, m);
        
        int[][] dp = new int[n + 1][m + 1];
        
        // bound
        for(int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for(int j = 1; j <= m; j++) {
            dp[0][j] = j;
        }
        
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }else {
                    dp[i][j] = minOfThree(dp[i][j - 1], dp[i - 1][j - 1], dp[i - 1][j]) + 1;
                    }
            }
        }
        
        return dp[n][m];
    }
    
    public int minOfThree(int a, int b, int c) {

            return Math.min(Math.min(a, b), c);

        }
}