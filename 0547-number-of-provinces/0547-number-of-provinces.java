class Solution {
    public int findCircleNum(int[][] isConnected) {
        int  n = isConnected.length;
        int ans = 0;
        boolean [] vis = new boolean [n];

        for(int i=0 ; i<n ; i++) {
            if(!vis[i]) {
                dfs(i , vis , isConnected);
                ans++;
            }
        }
        return ans;
    }

    public void dfs(int sv , boolean [] vis , int [][] adj) {
        vis[sv] = true;

        for(int ev=0 ; ev<adj.length ; ev++) {
            if(!vis[ev] && adj[sv][ev]==1) {
                dfs(ev , vis , adj);
            }
        }
    }
}