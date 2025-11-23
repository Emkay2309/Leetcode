class Solution {
    public int maxSumDivThree(int[] nums) {
        int dp[] = new int[3];

        for(int num : nums) {
            int next[] = dp.clone();
            for(int curr : dp) {
                int sum = curr + num;
                int index = sum%3;
                next[index] = Math.max(next[index], sum);
            }

            dp = next;
        }

        return dp[0];
    }
}