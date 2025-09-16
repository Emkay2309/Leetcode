class Solution {
    public int shortestBridge(int[][] grid) {
        
        int n = grid.length;
        int m = grid[0].length;
        int [][] dir = {
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        boolean [][] vis = new boolean [n][m];
        int row = -1 , col = -1;
        Queue<Pair> q = new LinkedList<>();

        boolean found = false;
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m && found != true ; j++) {
                if(grid[i][j] == 1) {
                    dfs(i , j  , vis , grid , q );
                    found = true;
                }
            }
        }

        int steps = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                Pair curr = q.poll();
                for (int[] d : dir) {
                    int nr = curr.r + d[0];
                    int nc = curr.c + d[1];
                    if (nr < 0 || nr >= n || nc < 0 || nc >= m || vis[nr][nc]) continue;

                    if (grid[nr][nc] == 1) {
                        return steps; 
                    }

                    vis[nr][nc] = true;
                    q.add(new Pair(nr, nc));
                }
            }
            steps++;
        }
        return -1;
    }

    public void dfs(int r , int c , boolean [][]vis , int [][] grid , Queue<Pair> q) {
        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length || grid[r][c]==0 || vis[r][c]) return;

        vis[r][c] = true;

        q.add(new Pair(r,c));

        dfs(r+1 , c , vis , grid , q);
        dfs(r-1 , c , vis , grid , q);
        dfs(r , c+1 , vis , grid , q);
        dfs(r , c-1 , vis , grid , q);
    }
}



class Pair {
    int r;
    int c;
    Pair(int r , int c) {
        this.r = r;
        this.c = c;
    }
}