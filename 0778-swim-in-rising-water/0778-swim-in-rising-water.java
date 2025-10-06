import java.util.*;

class Solution {

    int [][] dirs = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.h));
        
        pq.offer(new Pair(0, 0, grid[0][0]));
        vis[0][0] = true;
        
        int ans = grid[0][0];

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int row = curr.r;
            int col = curr.c;
            int height = curr.h;
            
            // Update maxTime to the maximum elevation we've encountered so far
            ans = Math.max(ans, height);
            
            // If we reached the destination
            if(row == n-1 && col == n-1) {
                return ans;
            }

            for(int [] d : dirs) {
                int newRow = row + d[0];
                int newCol = col + d[1];
                
                // Check bounds and if not visited
                if(newRow >= 0 && newRow <= n-1 && newCol >= 0 && newCol <= n-1 && !vis[newRow][newCol]) {
                    int h = grid[newRow][newCol];
                    pq.offer(new Pair(newRow, newCol, h));
                    vis[newRow][newCol] = true;
                }
            }
        }
        return ans;
    }
}

class Pair {
    int r, c, h;
    Pair(int r, int c, int h) {
        this.r = r;
        this.c = c;
        this.h = h;
    }
}