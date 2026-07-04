class Solution {
    int ans = Integer.MAX_VALUE; // Global variable to track the minimum score

    public int minScore(int n, int[][] roads) {
        boolean[] vis = new boolean[n + 1]; // Adjust size for 1-based indexing
        List<List<Pair>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Construct the graph (1-based indexing)
        for (int[] road : roads) {
            int sv = road[0];
            int ev = road[1];
            int wt = road[2];

            adj.get(sv).add(new Pair(ev, wt));
            adj.get(ev).add(new Pair(sv, wt));
        }

        // Start DFS from city 1
        dfs(1, vis, adj);

        return ans;
    }

    public void dfs(int curr, boolean[] vis, List<List<Pair>> adj) {
        vis[curr] = true;

        for (Pair neigh : adj.get(curr)) {
            int node = neigh.node;
            int wt = neigh.wt;

            // Update the minimum score (ans)
            ans = Math.min(ans, wt);

            // Visit the neighbor if not already visited
            if (!vis[node]) {
                dfs(node, vis, adj);
            }
        }
    }

    class Pair {
        int node;
        int wt;

        Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
}
