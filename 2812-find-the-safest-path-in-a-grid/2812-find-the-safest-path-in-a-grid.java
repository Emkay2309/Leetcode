import java.util.*;

class Solution {
    int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        
        // Step 1: Compute distance to nearest thief using multi-source BFS
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }
        
        // BFS to compute minimum distances
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int i = cell[0], j = cell[1];
            for (int[] d : dirs) {
                int ni = i + d[0], nj = j + d[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n && dist[ni][nj] == Integer.MAX_VALUE) {
                    dist[ni][nj] = dist[i][j] + 1;
                    q.offer(new int[]{ni, nj});
                }
            }
        }
        
        // Step 2: Use Dijkstra to find path with maximum minimum safety
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        pq.offer(new int[]{dist[0][0], 0, 0});
        
        int[][] maxMinDist = new int[n][n];
        for (int[] row : maxMinDist) Arrays.fill(row, -1);
        maxMinDist[0][0] = dist[0][0];
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int d = curr[0], i = curr[1], j = curr[2];
            
            if (i == n-1 && j == n-1) return d;
            
            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                    int newDist = Math.min(d, dist[ni][nj]);
                    if (newDist > maxMinDist[ni][nj]) {
                        maxMinDist[ni][nj] = newDist;
                        pq.offer(new int[]{newDist, ni, nj});
                    }
                }
            }
        }
        
        return 0;
    }
}