import java.util.*;

class Solution {
    public int[][] dir = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;

        int steps = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1]});
        
        // Mark the entrance as visited by converting it to a wall
        maze[entrance[0]][entrance[1]] = '+';

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];

                // Check if it's a boundary and not the entrance
                if ((row != entrance[0] || col != entrance[1]) &&
                    (row == 0 || row == n - 1 || col == 0 || col == m - 1)) {
                    return steps;
                }

                // Explore neighbors in all directions
                for (int[] d : dir) {
                    int newRow = row + d[0];
                    int newCol = col + d[1];

                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && maze[newRow][newCol] == '.') {
                        q.add(new int[]{newRow, newCol});
                        maze[newRow][newCol] = '+';  // Mark as visited
                    }
                }
            }
            steps++;
        }

        return -1;  // No exit found
    }
}
