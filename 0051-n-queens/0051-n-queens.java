class Solution {
    List<List<String>> ans  = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        if(n == 0) return ans;

        List<String> board = new ArrayList<>();

        for(int i=0; i<n ; i++) {
            StringBuilder row = new StringBuilder();
            for(int j=0; j<n ; j++) {
                row.append('.');
            }
            board.add(row.toString());
        }

        dfs( 0 , board);

        return ans;
    }

    public void dfs(int row , List<String> board) {
        if(row == board.size()) {
            ans.add(new ArrayList<>(board));
            return;
        }

        for(int col=0; col<board.size() ; col++) {
            if(isValid(row , col , board)) {
                
                StringBuilder newRow = new StringBuilder(board.get(row));
                
                newRow.setCharAt(col , 'Q');
                board.set(row , newRow.toString());

                dfs(row+1 , board);

                newRow.setCharAt(col , '.');
                board.set(row , newRow.toString());
            }
        }
    }


    public boolean isValid(int row , int col , List<String> board) {

        //look for up
        for(int i=row ; i>=0 ; i--) {
            if(board.get(i).charAt(col) == 'Q') return false;
        }

        //look for dia
        for(int i=row  , j=col; i>=0 && j>=0 ; i-- ,j--) {
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        //look for antiDia
        for(int i=row , j=col; i>=0 && j<board.size() ; i--,j++) {
            if(board.get(i).charAt(j) == 'Q') return false;
        }

        return true;
    }



}