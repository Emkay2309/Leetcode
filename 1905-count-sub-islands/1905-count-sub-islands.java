class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int count = 0;
        boolean [][] vis = new boolean [n][m];

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(!vis[i][j] && grid2[i][j] == 1) {
                    if(dfs(i,j,n,m,vis,grid1,grid2)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean dfs(int i,int j ,int n ,int m , boolean [][] vis ,int [][] grid1, int [][] grid2) {
        if(i<0 || i>=n || j>=m || j<0 || grid2[i][j] != 1) return true;

        // //we only need land ,this is water
        // if(grid2[i][j] != 1) return true;

        //mark visited if land
        grid2[i][j] = -1;

        //check in grid1
        boolean check = grid1[i][j] == 1;

        //Traverse in all directions
        boolean down =  dfs(i+1,j,n,m,vis,grid1,grid2);
        boolean up = dfs(i-1,j,n,m,vis,grid1,grid2);
        boolean left = dfs(i,j-1,n,m,vis,grid1,grid2);
        boolean right = dfs(i,j+1,n,m,vis,grid1,grid2);
        
        //compare check in all directions
        return check && up && down && left && right;
    }
}