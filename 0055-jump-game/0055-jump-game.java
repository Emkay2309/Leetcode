class Solution {
    public boolean canJump(int [] nums) {
        int n = nums.length;
        if(n == 1 && nums[0] == 0) return true;
        Boolean [] dp = new Boolean [n];
        Arrays.fill(dp , null);
        if(nums[0] == 0) return false; 
        return dfs( 0 , nums , dp);
    }

    public boolean dfs(int i , int [] nums , Boolean [] dp) {
        if(i == nums.length-1) return true;

        if(i >= nums.length) return false;

        // recursive call 
        int times = nums[i]; //2

        for(int j=1 ; j<=times ; j++) {
            Boolean check =dfs( i + j , nums , dp);
            if(check) {
                return dp[i] = true;
            }    
        }
        return dp[i] = false;
        
    }
}