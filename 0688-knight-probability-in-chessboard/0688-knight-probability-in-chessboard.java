class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // DP table where dp[step][r][c] stores probability of being on (r,c) after "step" moves
        double[][][] dp = new double[k + 1][n][n];

        // Base case: If no moves are left, the knight is definitely on the board
        dp[0][row][column] = 1.0;

        // All possible knight moves
        int[][] directions = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};

        // Iterate over the number of moves from 1 to k
        for (int step = 1; step <= k; step++) {
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    // Transition from previous step
                    for (int[] dir : directions) {
                        int prevRow = r - dir[0];
                        int prevCol = c - dir[1];

                        // Check if the previous position was within bounds
                        if (prevRow >= 0 && prevRow < n && prevCol >= 0 && prevCol < n) {
                            dp[step][r][c] += dp[step - 1][prevRow][prevCol] / 8.0;
                        }
                    }
                }
            }
        }

        // Sum up probabilities after k moves
        double result = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result += dp[k][r][c];
            }
        }

        return result;
    }
}
