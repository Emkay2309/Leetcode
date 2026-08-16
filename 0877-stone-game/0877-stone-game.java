class Solution {
    Integer [][] dp;
    int n;
    public boolean stoneGame(int[] piles) {
        n = piles.length;
        dp = new Integer [n][n];
        return solve(0,n-1 , piles) > 0;
    }

    public int solve(int left , int right , int [] piles) {
        if(left > right) return 0;
        if(dp[left][right] != null) return dp[left][right];

        int takeLeft  = piles[left]  - solve(left+1 , right , piles);
        int takeRight = piles[right] - solve(left , right-1 , piles);

        return dp[left][right] = Math.max(takeLeft , takeRight); 
    }
}