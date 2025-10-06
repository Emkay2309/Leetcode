import java.util.*;

class Solution {
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        
        int[][] dist = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        
        // min-heap based on effort
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int i = curr[0], j = curr[1], effort = curr[2];
            
            // If we reached destination, return the effort
            if (i == n - 1 && j == m - 1) {
                return effort;
            }
            
            // If we found a better path to this cell already, skip
            if (effort > dist[i][j]) {
                continue;
            }
            
            for (int[] dir : dirs) {
                int ni = i + dir[0];
                int nj = j + dir[1];
                
                if (ni >= 0 && ni < n && nj >= 0 && nj < m) {
                    int newEffort = Math.max(effort, Math.abs(heights[i][j] - heights[ni][nj]));
                    
                    if (newEffort < dist[ni][nj]) {
                        dist[ni][nj] = newEffort;
                        pq.offer(new int[]{ni, nj, newEffort});
                    }
                }
            }
        }
        
        return 0;
    }
}