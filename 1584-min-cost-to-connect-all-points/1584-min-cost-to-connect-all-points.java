public class Solution {
    public int minKey(boolean[] inMST, int[] key) {
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < key.length; i++) {
            if (!inMST[i] && key[i] < minValue) {
                minIndex = i;
                minValue = key[i];
            }
        }
        return minIndex;
    }

    public int MST(int[][] graph, int V) {
        int[] key = new int[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        boolean[] inMST = new boolean[V];
        key[0] = 0;

        for (int count = 1; count <= V - 1; count++) {
            int u = minKey(inMST, key);
            inMST[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !inMST[v] && graph[u][v] < key[v]) {
                    key[v] = graph[u][v];
                }
            }
        }

        int cost = 0;
        for (int i : key) {
            cost += i;
        }
        return cost;
    }

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        int[][] graph = new int[n][n];

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int[] p1 = points[i];
                int[] p2 = points[j];
                int md = Math.abs(p1[0] - p2[0]) + Math.abs(p1[1] - p2[1]);
                graph[i][j] = md;
                graph[j][i] = md;
            }
        }

        return MST(graph, n);
    }

}
