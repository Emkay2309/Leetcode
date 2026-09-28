class Solution {

    int[] visited;
    int mark;

    public int maximumDetonation(int[][] bombs) {

        int n = bombs.length;

        visited = new int[n];

        int ans = 0;

        for (int i = 0; i < n; i++) {

            mark++;

            int count = dfs(i, bombs);

            ans = Math.max(ans, count);
        }

        return ans;
    }

    private int dfs(int curr, int[][] bombs) {

        visited[curr] = mark;

        int count = 1;

        long x1 = bombs[curr][0];
        long y1 = bombs[curr][1];
        long r = bombs[curr][2];

        for (int i = 0; i < bombs.length; i++) {

            if (visited[i] == mark) {
                continue;
            }

            long dx = bombs[i][0] - x1;
            long dy = bombs[i][1] - y1;

            if (dx * dx + dy * dy <= r * r) {
                count += dfs(i, bombs);
            }
        }

        return count;
    }
}