class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int ans = 0;

        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(grid[i][j] == '1') {
                    ans++;
                    dfs(i , j , n , m , grid);
                }
            }
        }
        return ans;
    }

    public void dfs(int i , int j , int n , int m , char [][] mat) {
        if(i<0 || i>=n || j<0 || j>=m || mat[i][j] == '0') return;

        mat[i][j] = '0';

        dfs(i+1 , j , n , m , mat);
        dfs(i-1 , j , n , m , mat);
        dfs(i , j-1 , n , m , mat);
        dfs( i , j+1 , n , m , mat);
    }
}