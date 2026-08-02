class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Integer[][] memo = new Integer[n][n];
        return solve(0, n - 1, piles, memo) > 0;
    }
    
    private int solve(int l, int r, int[] piles, Integer[][] memo) {
        if (l > r) return 0;
        if (memo[l][r] != null) return memo[l][r];
        
        int takeLeft = piles[l] - solve(l + 1, r, piles, memo);
        int takeRight = piles[r] - solve(l, r - 1, piles, memo);
        
        memo[l][r] = Math.max(takeLeft, takeRight);
        return memo[l][r];
    }
}