class Solution {
    public int rob(int [] nums) {
        int n = nums.length;
        int [] dp = new int [n];
        Arrays.fill(dp,-1);
        return dfs(0,n,dp,nums);
    }

    public int dfs(int i , int n , int [] dp , int [] arr) {
        if(i >= n ) return 0;
        if(dp[i] != -1 )    return dp[i];

        int rob = arr[i] + dfs(i+2 , n , dp, arr);
        int nRob = dfs(i+1 , n , dp, arr);

        return dp[i] = Math.max(rob,nRob);
    }
}