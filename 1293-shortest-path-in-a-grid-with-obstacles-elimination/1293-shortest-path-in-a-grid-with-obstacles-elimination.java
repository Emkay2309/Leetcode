class Solution {
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        // If we can eliminate enough obstacles to go straight, return Manhattan distance
        if (k >= n + m - 2) {
            return n + m - 2;
        }
        
        // BFS with state (row, col, remaining_eliminations)
        boolean[][][] visited = new boolean[n][m][k + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, k, 0}); // {row, col, remaining_k, steps}
        visited[0][0][k] = true;
        
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int row = current[0], col = current[1], remaining = current[2], steps = current[3];
            
            // Reached destination
            if (row == n - 1 && col == m - 1) {
                return steps;
            }
            
            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];
                
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                    int newRemaining = remaining - grid[newRow][newCol];
                    
                    if (newRemaining >= 0 && !visited[newRow][newCol][newRemaining]) {
                        visited[newRow][newCol][newRemaining] = true;
                        queue.offer(new int[]{newRow, newCol, newRemaining, steps + 1});
                    }
                }
            }
        }
        
        return -1; // No path found
    }
}