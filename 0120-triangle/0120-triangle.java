class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer [][] dp = new Integer [n][n];
        return dfs(0,0,triangle , dp);
    }

    public int dfs(int row , int col , List<List<Integer>> mat , Integer [][] dp ) {
        if(row == mat.size()) return 0;

        if(dp[row][col] != null) return dp[row][col];

        int down = dfs(row+1 , col , mat , dp);
        int dia =  dfs(row+1 , col+1 , mat , dp);

        return dp[row][col] = mat.get(row).get(col) + Math.min(down , dia);
    }
}