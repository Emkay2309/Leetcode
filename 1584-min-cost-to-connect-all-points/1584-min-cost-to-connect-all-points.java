import java.util.*;

class Pair {
    int weight;
    int vertex;

    Pair(int weight, int vertex) {
        this.weight = weight;
        this.vertex = vertex;
    }
}

class Solution {
    public int minMST(List<List<Pair>> adj, int V) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight)); // min heap
        pq.offer(new Pair(0, 0)); // {weight, vertex}

        boolean[] vis = new boolean[V];
        int sum = 0;

        while (!pq.isEmpty()) {
            Pair p = pq.poll();

            int wt = p.weight;
            int node = p.vertex;

            if (vis[node])
                continue;

            vis[node] = true; // added to MST
            sum += wt;

            for (Pair tmp : adj.get(node)) {
                int neighbor = tmp.vertex;
                int neighborWt = tmp.weight;

                if (!vis[neighbor]) {
                    pq.offer(new Pair(neighborWt, neighbor));
                }
            }
        }

        return sum;
    }

    public int minCostConnectPoints(int[][] points) {
        int V = points.length;

        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            for (int j = i + 1; j < V; j++) {
                int x1 = points[i][0];
                int y1 = points[i][1];

                int x2 = points[j][0];
                int y2 = points[j][1];

                int d = Math.abs(x1 - x2) + Math.abs(y1 - y2);

                adj.get(i).add(new Pair(d, j));
                adj.get(j).add(new Pair(d, i));
            }
        }

        return minMST(adj, V);
    }
}
