class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        
        // Try all possible times from grid[0][0] to maximum elevation
        for (int time = grid[0][0]; time <= n * n - 1; time++) {
            boolean[][] visited = new boolean[n][n];
            if (dfs(0, 0, grid, visited, time)) {
                return time;
            }
        }
        return n * n - 1;
    }
    
    private boolean dfs(int r, int c, int[][] grid, boolean[][] visited, int time) {
        int n = grid.length;
        
        // Base case: reached destination
        if (r == n - 1 && c == n - 1) {
            return true;
        }
        
        visited[r][c] = true;
        
        // Directions: up, down, left, right
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        
        for (int[] dir : directions) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            
            // Check if new position is valid and not visited
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && 
                !visited[nr][nc] && grid[nr][nc] <= time) {
                
                if (dfs(nr, nc, grid, visited, time)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}