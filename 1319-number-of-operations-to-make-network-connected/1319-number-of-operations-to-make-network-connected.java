class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if(n-1 > len) return -1;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ;i<n ; i++) {
            adj.add(new ArrayList<>());
        }

        for(int [] e : connections) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        } 

        int count = 0;
        boolean [] vis = new boolean [n];
        for(int i=0 ; i<n ; i++) {
            if(!vis[i]) {
                dfs( i , vis , adj);
                count++;
            }
        }

        return count-1;
    }

    public void dfs(int curr , boolean [] vis , List<List<Integer>> adj) {
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(neigh , vis , adj);
            }
        }
    }
}