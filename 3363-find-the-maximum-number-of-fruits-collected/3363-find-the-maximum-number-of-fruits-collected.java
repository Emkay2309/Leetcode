import java.util.*;

class Solution {
    // DFS for the child starting from (n-1, 0)
    private int dfs1(int[][] fruits, int i, int j, int[][] dp) {
        int n = fruits.length;

        // Base case: If we reach the destination (n-1, n-1)
        if (i == n - 1 && j == n - 1)
            return 0;

        // Invalid state: The current column index (j) must be less than the row index (i)
        if (j >= i)
            return 0;

        // Use memoized result if available
        if (dp[i][j] != -1)
            return dp[i][j];

        int maxFruits = 0;

        // Explore all possible moves for the child
        for (int d = -1, ii = i - 1; d <= 1; d++, ii++) {
            if (ii >= 0 && ii < n) // Ensure the move is within bounds
                maxFruits = Math.max(maxFruits, dfs1(fruits, ii, j + 1, dp));
        }

        // Store and return the maximum fruits collected from this point
        return dp[i][j] = maxFruits + fruits[i][j];
    }

    // DFS for the child starting from (0, n-1)
    private int dfs2(int[][] fruits, int i, int j, int[][] dp) {
        int n = fruits.length;

        // Base case: If we reach the destination (n-1, n-1)
        if (i == n - 1 && j == n - 1)
            return 0;

        // Invalid state: The current row index (i) must be less than the column index (j)
        if (i >= j)
            return 0;

        // Use memoized result if available
        if (dp[i][j] != -1)
            return dp[i][j];

        int maxFruits = 0;

        // Explore all possible moves for the child
        for (int d = -1, jj = j - 1; d <= 1; d++, jj++) {
            if (jj >= 0 && jj < n) // Ensure the move is within bounds
                maxFruits = Math.max(maxFruits, dfs2(fruits, i + 1, jj, dp));
        }

        // Store and return the maximum fruits collected from this point
        return dp[i][j] = maxFruits + fruits[i][j];
    }

    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;
        int totalFruits = 0;

        // Collect fruits from the diagonal path (0, 0) -> (n-1, n-1)
        for (int i = 0; i < n; i++) {
            totalFruits += fruits[i][i];
        }

        // Create DP tables for the two additional children
        int[][] dp1 = new int[n][n]; // For child starting at (n-1, 0)
        int[][] dp2 = new int[n][n]; // For child starting at (0, n-1)

        for (int[] row : dp1) Arrays.fill(row, -1);
        for (int[] row : dp2) Arrays.fill(row, -1);

        // Add maximum fruits collected by the two children
        totalFruits += dfs1(fruits, n - 1, 0, dp1); // Child 1 (from (n-1, 0))
        totalFruits += dfs2(fruits, 0, n - 1, dp2); // Child 2 (from (0, n-1))

        return totalFruits;
    }
}
