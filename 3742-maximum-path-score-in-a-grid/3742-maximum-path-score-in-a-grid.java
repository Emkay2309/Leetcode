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
        return ans == -INF ? -1 : ans;
    }

    private int dfs(int i, int j, int remK) {
        if (i >= grid.length || j >= grid[0].length) return -INF;

        int cost = (grid[i][j] != 0) ? 1 : 0;
        if (remK < cost) return -INF;

        // destination
        if (i == grid.length - 1 && j == grid[0].length - 1) {
            return grid[i][j];
        }

        if (memo[i][j][remK] != null) return memo[i][j][remK];

        int right = dfs(i, j + 1, remK - cost);
        int down = dfs(i + 1, j, remK - cost);

        int best = Math.max(right, down);

        if (best == -INF) return memo[i][j][remK] = -INF;

        return memo[i][j][remK] = grid[i][j] + best;
    }
}