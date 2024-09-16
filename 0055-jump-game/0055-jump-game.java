class Solution {
    public boolean canJump(int[] nums) {
        Boolean [] dp = new Boolean [nums.length];
        Arrays.fill(dp , null);
        return dfs(0 , nums , dp);
    }
    public boolean dfs(int i , int [] nums , Boolean [] dp) {
        if(i == nums.length-1) return true;

        if(i >= nums.length ) return false;

        if(dp[i] != null) return dp[i];

        for(int j=1 ; j<=nums[i] ; j++) {
            boolean check = dfs(i+j , nums , dp);
            if(check ) 
                return dp[i] = true;
        }

        return dp[i] = false;
    }
}