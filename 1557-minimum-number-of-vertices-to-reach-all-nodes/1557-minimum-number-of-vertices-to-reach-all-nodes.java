class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean [] vis = new boolean [n];
        List<Integer> ans = new ArrayList<>();

        //create graph
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0 ; i<n ; i++) {
            adj.add(new ArrayList<>());
        }
        int [] indegree = new int [n];
        for(List<Integer> edge : edges) {
            int sv = edge.get(0);
            int ev = edge.get(1);

            adj.get(sv).add(ev);
            
            indegree[ev]++;
        }

        for(int i=0 ; i<n ; i++) {
            if(!vis[i] && indegree[i] == 0) {
                dfs(i , vis , adj);
                ans.add(i);
            }
        }
        return ans;
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