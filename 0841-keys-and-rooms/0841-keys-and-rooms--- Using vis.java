class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        int count = 0;
        boolean [] vis = new boolean [n];        
        for(int i=0 ; i<n ; i++) {  
            if(!vis[i]) {
                dfs(i , vis , rooms);
                count++;
            }
        }
        return count == 1;
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