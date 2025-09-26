class Solution {
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length , m = grid[0].length;
        int [][] vis = new int [n][m];

        return dfs(0,0,n,m,vis, grid);
    }

    public boolean dfs(int i,int j , int n , int m , int [][] vis , int [][] grid) {
        if(i<0 || i>=n || j<0 || j>=m || vis[i][j]==1 ) return false;

        if(i==n-1 && j==m-1) return true;

        int dir = grid[i][j];
        vis[i][j] = 1;

        boolean way= false;
        if(dir==1) {
            way = dfs(i , j+1 , n , m , vis , grid);
        }
        else if(dir==2) {
            way = dfs(i+1 , j , n , m , vis , grid);
        }
        else if(dir==3) {
            way = dfs(i+1 , j+1 , n , m , vis , grid);
        }
        else if(dir==4) {
            way = dfs(i-1 , j+1 , n , m , vis , grid);
        }
        else if(dir==5) {
            way = dfs(i-1 , j+1 , n , m , vis , grid);
        }
        else {
            way = dfs(i-1 , j-1 , n , m , vis , grid);
        }
        vis[i][j] = 0;
        return way;

    }
}