class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        if(n==0) return ;

        for(int j=0 ; j<m ; j++) {
            if(board[0][j] == 'O') {
                dfs(board, 0 , j);
            }
            if(board[n-1][j] == 'O') {
                dfs(board , n-1 , j);
            }
        }

        for(int i=0 ; i<n ; i++)  {
            if(board[i][0] == 'O') {
                dfs(board , i , 0 );
            }
            if(board[i][m-1] == 'O') {
                dfs(board , i , m-1);
            }
        }
        
        for(int i=0 ; i<n ; i++) {
            for(int j=0 ; j<m ; j++) {
                if(board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
                else if(board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
   
    }
    public void dfs(char[][]mat , int row , int col ) {
        if(row<0 || col<0 || row>=mat.length || col >= mat[0].length || mat[row][col] != 'O' ) {
            return;
        }
        mat[row][col] = 'A';

        dfs(mat , row+1 , col);
        dfs(mat , row-1 , col);
        dfs(mat , row , col+1);
        dfs(mat , row , col-1);
    }
}