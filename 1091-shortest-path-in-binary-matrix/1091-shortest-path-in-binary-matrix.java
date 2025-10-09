class Solution {

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        grid[0][0] = 1; // mark visited
        int ans = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                int[] curr = q.poll();
                int i = curr[0], j = curr[1];

                if (i == n - 1 && j == n - 1) return ans;

                for (int[] d : dirs) {
                    int nr = i + d[0];
                    int nc = j + d[1];

                    if (isSafe(nr, nc, grid)) {
                        q.offer(new int[]{nr, nc});
                        grid[nr][nc] = 1; // mark visited
                    }
                }
            }
            ans++;
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
