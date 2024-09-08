class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean [] vis = new boolean [n];
        return dfs(source , destination , adj , vis);
    }

    public boolean dfs(int curr , int dest , List<List<Integer>> adj  , boolean [] vis) {
        vis[curr] = true;

        if(curr == dest) return true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                boolean check = dfs(neigh , dest , adj , vis);
                if(check) return true;
            }
        }
        return false;
    }
}