import java.util.Arrays;

class Solution {
    static final int MOD = 1000000007;

    public int uniquePaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] dp = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        // use your original method signature style (start dir = 0 as in your correct snippet)
        return dfs(0, 0, n, m, 0, grid, dp);
    }

    // kept a signature similar to your earlier code but added dp as last param
    public int dfs(int i, int j, int n, int m, int dir, int[][] grid, int[][][] dp) {
        if (i == n - 1 && j == m - 1) return 1;
        if (i >= n || j >= m) return 0;
        if (dp[i][j][dir] != -1) return dp[i][j][dir];

        long ways = 0;

        if (i < n && j < m && grid[i][j] == 1) {
            // mirror: flip direction and move once
            if (dir == 0) ways = dfs(i + 1, j, n, m, 1, grid, dp);
            else ways = dfs(i, j + 1, n, m, 0, grid, dp);
        } else {
            // normal cell: continue moving deterministically
            ways += dfs(i + 1, j, n, m, 1, grid, dp);
            ways += dfs(i, j + 1, n, m, 0, grid, dp);
        }

        return dp[i][j][dir] = (int)(ways % MOD);
    }
}
