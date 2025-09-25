class Solution {

    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer [][] dp = new Integer [n][n];
        return dfs( 0 , 0 , triangle , dp);
    }

    public int dfs(int i, int j , List<List<Integer>> mat , Integer [][] dp) {
        if(i == mat.size()) return 0;

        if(dp[i][j] != null) {
            return dp[i][j];
        }

        Integer down = dfs(i+1 , j , mat , dp);
        Integer right = dfs(i+1 , j+1 , mat , dp);

        return   dp[i][j] = mat.get(i).get(j) + Math.min(down , right);
    }
}