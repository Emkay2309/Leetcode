class Solution {
    public int[][] directions = { { 1, 2 }, { 1, -2 }, { -1, 2 }, { -1, -2 }, { 2, 1 }, { 2, -1 }, { -2, 1 }, { -2, -1 } };

    public double[][][] memo;

    public double knightProbability(int n, int k, int row, int column) {
        memo = new double[n][n][k + 1];
        for (double[][] layer : memo) {
            for (double[] rowArr : layer) {
                Arrays.fill(rowArr, -1.0);
            }
        }
        return solve(row, column, k, n);
    }

    public double solve(int r, int c, int k, int n) {
        if (r < 0 || r >= n || c < 0 || c >= n) return 0.0;

        if (k == 0) return 1.0;

        if (memo[r][c][k] != -1.0)  return memo[r][c][k];

        double ans = 0.0;

        for (int[] dir : directions) {
            int n_row = r + dir[0];
            int n_col = c + dir[1];

            ans += solve(n_row, n_col, k - 1, n) / 8.0;
        }

        return memo[r][c][k] = ans;
    }
}