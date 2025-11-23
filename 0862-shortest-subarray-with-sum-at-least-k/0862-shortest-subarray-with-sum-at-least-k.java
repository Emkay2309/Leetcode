class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        for(int val : nums) {
            sum += val;
        }

        if(sum < k) return -1;
        if(sum == k) return n;

        int s = 0;
        sum = 0;
        int ans = 0;

        for(int e=0 ; e<n ; e++) {
            sum += nums[e];

            if(sum == k) {
                int len = e-s+1;
                ans = Math.max(ans , len);
            }
            else if( sum > k) {
                s++;
                sum -= nums[s];
            }
        }
        return ans;
    }
}