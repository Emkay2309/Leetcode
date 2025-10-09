class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] dist = new int[n][n];
        for (int [] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 1;
        grid[0][0] = 1;

        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a->a.d));
        pq.offer(new Pair(0,0,0));

        while(!pq.isEmpty()) {
            Pair curr = pq.poll();
            int r = curr.r , c = curr.c , d = curr.d;

            if(r==n-1 && c==n-1) {
                return d+1;
            }

            for(int [] dir : dirs) {
                int nr = dir[0] + r , nc = dir[1] + c , nd = 1 + d;

                if(isSafe(nr , nc , grid)) {
                    pq.offer(new Pair(nr , nc , nd));
                    grid[nr][nc] = 1;
                    dist[nr][nc] = nd;
                }
            }
        }

        return -1;
    }

    public boolean isSafe(int i, int j, int[][] grid) {
        int n = grid.length;
        return i >= 0 && i < n && j >= 0 && j < n && grid[i][j] == 0;
    }

    int[][] dirs = {
                {-1, -1}, {-1, 0}, {-1, 1},{0, -1},{0, 1},{1, -1},  {1, 0},  {1, 1}
            };
}

class Pair {
    int r,d,c;
    Pair(int r , int c , int d) {
        this.r = r;
        this.c = c;
        this.d = d;
    }
}