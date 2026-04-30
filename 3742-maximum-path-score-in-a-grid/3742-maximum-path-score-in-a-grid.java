class Solution {
    private int[][] grid;
    private Integer[][][] memo;
    private static final int INF = 1 << 30;
    
    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        this.memo = new Integer[m][n][k + 1];
        
        int ans = dfs(0, 0, k);
        return ans < 0 ? -1 : ans;
    }
    
    // Max score to reach (i,j) from (0,0) with exactly 'used' changes so far
    private int dfs(int i, int j, int used) {
        if (used > k) return -INF;
        
        if (i == 0 && j == 0) {
            return grid[0][0];
        }
        
        if (memo[i][j][used] != null) return memo[i][j][used];
        
        int cost = (grid[i][j] == 0 ? 0 : 1);
        
        int maxScore = -INF;
        // From up
        if (i > 0) {
            int prev = dfs(i - 1, j, used - cost);
            if (prev != -INF) maxScore = Math.max(maxScore, prev + grid[i][j]);
        }
        // From left
        if (j > 0) {
            int prev = dfs(i, j - 1, used - cost);
            if (prev != -INF) maxScore = Math.max(maxScore, prev + grid[i][j]);
        }
        
        return memo[i][j][used] = maxScore;
    }
}