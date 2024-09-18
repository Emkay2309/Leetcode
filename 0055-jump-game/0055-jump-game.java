class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        Boolean [] dp = new Boolean [n];
        Arrays.fill(dp , null);
        return dfs(0 , n, nums , dp);
    }

    public boolean dfs(int i , int n , int [] nums , Boolean [] dp) {
        if(i == n-1) return true;
        if(i >= n) return false;

        if(dp[i] != null) return dp[i];

        int size = nums[i];

        for(int j=1 ; j<=size ; j++) {
            if(dfs(j+i , n , nums , dp)) {
                return dp[i] =  true;
            }
        }

        return dp[i] = false;
    }
}