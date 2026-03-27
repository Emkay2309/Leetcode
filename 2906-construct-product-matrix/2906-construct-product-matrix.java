class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int mod = 12345;

        int[][] pf = new int[n][m];
        int[][] sf = new int[n][m];

        long product = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pf[i][j] = (int) product;
                product = (product * grid[i][j]) % mod;
            }
        }

        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                sf[i][j] = (int)  product;
                product = (product * grid[i][j]) % mod;
            }
        }

        // Final result
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = (pf[i][j] * sf[i][j]) % mod;
            }
        }

        return grid;
    }
}