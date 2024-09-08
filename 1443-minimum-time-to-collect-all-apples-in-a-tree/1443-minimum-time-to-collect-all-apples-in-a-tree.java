class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int sv = edge[0];
            int ev = edge[1];

            adj.get(sv).add(ev);
            adj.get(ev).add(sv);
        }

        return dfs(0, -1, adj, hasApple);

    }

    public int dfs(int curr, int par, List<List<Integer>> adj, List<Boolean> hasApple) {
        int time = 0;

        for (int child : adj.get(curr)) {
            if (child == par)
                continue;

            int time_from_child = dfs(child, curr, adj, hasApple);

            if (time_from_child > 0 || hasApple.get(child)) {
                time += (time_from_child + 2);
            }
        }
        return time;
    }
}