class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean [][] vis = new boolean [m][n];
        int ans = 0;
        for(int i=0; i<m ; i++) {
            for(int j=0 ; j<n ; j++) {
                if(!vis[i][j] && grid[i][j]==1) {
                    int[] count = new int[1];
                    dfs(i,j,m,n,count,vis,grid);
                    ans = Math.max(ans , count[0]);
                } 
            }
        }
        return ans;
    }

    public void dfs(int i, int j , int m ,int n , int count [] , boolean [][] vis , int [][] grid) {
        if(i<0 || i>=m || j<0 || j>=n || vis[i][j] || grid[i][j]==0) return;

        vis[i][j] = true;
        count[0]++;
        dfs(i+1,j,m,n,count,vis,grid);
        dfs(i-1,j,m,n,count,vis,grid);
        dfs(i,j+1,m,n,count,vis,grid);
        dfs(i,j-1,m,n,count,vis,grid);
    }
}