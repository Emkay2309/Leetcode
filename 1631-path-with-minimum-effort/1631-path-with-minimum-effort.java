class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int minimumEffortPath(int[][] heights) {
        int left = 0;
        int right = 1000000; // Max possible effort
        int result = right;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (canReach(heights, mid)) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return result;
    }
    
    private boolean canReach(int[][] heights, int maxEffort) {
        int n = heights.length;
        int m = heights[0].length;
        boolean[][] visited = new boolean[n][m];
        
        return dfs(0, 0, heights, visited, maxEffort);
    }
    
    private boolean dfs(int i, int j, int[][] heights, boolean[][] visited, int maxEffort) {
        int n = heights.length;
        int m = heights[0].length;
        
        if (i == n-1 && j == m-1) {
            return true;
        }
        
        visited[i][j] = true;
        
        for (int[] dir : dirs) {
            int ni = i + dir[0];
            int nj = j + dir[1];
            
            if (ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj]) {
                int effort = Math.abs(heights[i][j] - heights[ni][nj]);
                if (effort <= maxEffort) {
                    if (dfs(ni, nj, heights, visited, maxEffort)) {
                        return true;
                    }
                }
            }
        }
        
        return false;
    }
}