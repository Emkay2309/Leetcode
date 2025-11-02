class Solution {
    int MOD = 1000000007;

    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        for (int[] row : dp) Arrays.fill(row, -1);

        return dfs(n, k, target, dp) % MOD;
    }

    int dfs(int n, int k, int target, int[][] dp) {
        if (n == 0 && target == 0) return 1;
        if (n == 0 || target <= 0) return 0;

        if (dp[n][target] != -1) return dp[n][target];

        int ways = 0;
        for (int i = 1; i <= k; i++) {
            ways = (ways + dfs(n - 1, k, target - i, dp)) % MOD;
        }

        dp[n][target] = ways;
        return ways;
    }
}
