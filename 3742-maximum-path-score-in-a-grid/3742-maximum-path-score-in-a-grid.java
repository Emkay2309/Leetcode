class Solution {
    private int[][] grid;
    private Integer[][][] memo;
    private static final int INF = 1 << 30;
    
    public int maxPathScore(int[][] grid, int k) {
        this.grid = grid;
        int m = grid.length;
        int n = grid[0].length;
        this.memo = new Integer[m][n][k + 1];
        
        int ans = dfs(m - 1, n - 1, k);
        return ans < 0 ? -1 : ans;
    }
    
    private int dfs(int i, int j, int remK) {
        // Invalid state: out of bounds or no more changes allowed
        if (i < 0 || j < 0 || remK < 0) {
            return -INF;
        }
        
        // Base case: start position
        if (i == 0 && j == 0) {
            return 0;
        }
        
        // Memo check
        if (memo[i][j][remK] != null) {
            return memo[i][j][remK];
        }
        
        // Consume cost if cell > 0
        int currK = remK;
        if (grid[i][j] > 0) {
            currK--;
        }
        
        // Recur from up and left (paths come from there)
        int fromUp = dfs(i - 1, j, currK);
        int fromLeft = dfs(i, j - 1, currK);
        int maxPrev = Math.max(fromUp, fromLeft);
        
        // If no valid path from previous, invalid
        if (maxPrev == -INF) {
            return memo[i][j][remK] = -INF;
        }
        
        // Add current cell value
        return memo[i][j][remK] = grid[i][j] + maxPrev;
    }
}