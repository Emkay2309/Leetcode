class Solution {
    public boolean canPartitionGrid(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[] rowSum = new int[n];
        int[] colSum = new int[m];

        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                rowSum[i] += grid[i][j];
                colSum[j] += grid[i][j];
                totalSum += grid[i][j];
            }
        }

        if (totalSum % 2 != 0) return false;

        long upperSum = 0;

        // Horizontal split
        for (int i = 0; i < n - 1; i++) {
            upperSum += rowSum[i];
            long lowerSum = totalSum - upperSum;
            if (upperSum == lowerSum) return true;
        }

        upperSum = 0;

        // Vertical split
        for (int j = 0; j < m - 1; j++) {
            upperSum += colSum[j];
            long lowerSum = totalSum - upperSum;
            if (upperSum == lowerSum) return true;
        }

        return false;
    }
}