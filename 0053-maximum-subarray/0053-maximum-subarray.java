class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for(int val : nums) {
            sum += val;
            ans = Math.max(ans , sum);
            if(sum < 0) {
                sum = 0;
            }
        }
        return ans;
    }
}