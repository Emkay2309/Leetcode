class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];

        int min = nums[0];
        int max = nums[0];
        int ans = nums[0];

        for (int i = 1; i < n; i++) {
            int curr = nums[i];
            
            int prevMax = max;
            
            // Update max: could be curr, max*curr, or min*curr (for negative numbers)
            max = Math.max(curr, Math.max(max * curr, min * curr));
            
            // Update min: could be curr, prevMax*curr, or min*curr
            min = Math.min(curr, Math.min(prevMax * curr, min * curr));
            
            // Update global answer
            ans = Math.max(ans, max);
        }
        return ans;
    }
}