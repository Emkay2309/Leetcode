class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        // Two DP arrays to store current and previous step probabilities
        double[][] prev = new double[n][n];
        double[][] curr = new double[n][n];

        // Base case: The knight starts at (row, column)
        prev[row][column] = 1.0;

        // All possible knight moves
        int[][] directions = {{1,2}, {1,-2}, {-1,2}, {-1,-2}, {2,1}, {2,-1}, {-2,1}, {-2,-1}};

        // Iterate over the number of moves
        for (int step = 1; step <= k; step++) {
            // Reset current step DP table
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    curr[r][c] = 0.0;
                }
            }

            // Fill the DP table for the current step
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    if (prev[r][c] > 0) {  // Only process cells with probability > 0
                        for (int[] dir : directions) {
                            int newRow = r + dir[0];
                            int newCol = c + dir[1];

                            // If the new position is within bounds, add probability
                            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n) {
                                curr[newRow][newCol] += prev[r][c] / 8.0;
                            }
                        }
                    }
                }
            }

            // Swap `prev` and `curr` to save space (rolling array technique)
            double[][] temp = prev;
            prev = curr;
            curr = temp;
        }

        // Sum up probabilities from the last valid `prev` array
        double result = 0.0;
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                result += prev[r][c];
            }
        }

        return result;
    }
}
