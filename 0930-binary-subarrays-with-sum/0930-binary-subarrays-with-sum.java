class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0, left = 0, sum = 0, n = nums.length , zero = 0;

        for (int right = 0; right < n; right++) {
            int add = nums[right];
            sum += add;

            while (left < right && (sum > goal || nums[left] == 0) ) {
                if(nums[left] == 0) {
                    zero++;
                }
                else {
                    zero = 0;
                }
                sum -= nums[left];
                left++;
            }

            if (sum == goal) {
                ans += 1 + zero;
            }
        }
        return ans;
    }
}
