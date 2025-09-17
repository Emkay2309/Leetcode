class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int [] dp = new int[n+1];
        Arrays.fill(dp,-1);

        return dfs(0,dp,nums);
    }

    public int dfs(int index, int[] dp, int[] nums) {
        if (index == nums.length - 1) return 0;

        if (dp[index] != -1) return dp[index];

        int ans = Integer.MAX_VALUE;
        int stepsAllowed = nums[index];

        for (int i = 1; i <= stepsAllowed && index + i < nums.length; i++) {

            int steps = dfs(index + i, dp, nums);

            if(steps != Integer.MAX_VALUE)  
                ans = Math.min(ans,steps+1);
            
        }
        return dp[index] = ans;
    }
}