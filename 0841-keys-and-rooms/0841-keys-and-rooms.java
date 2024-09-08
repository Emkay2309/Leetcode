class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int count = 0;
        int V = rooms.size();
        boolean [] vis = new boolean [rooms.size()];
        for(int i=0 ; i<V ; i++)  {
            if(!vis[i]) {
                count++;
                dfs(rooms , vis , i );
            }
        }
        return count == 1;
    }
    public void dfs(List<List<Integer>> adj , boolean [] vis , int curr)  {
        vis[curr] = true;

        for(int neigh : adj.get(curr)) {
            if(!vis[neigh]) {
                dfs(adj , vis , neigh);
            }
        }
    }
}