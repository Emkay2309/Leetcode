class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            int next = nums[(i + 1) % n];  // Wrap around for last element
            
            int diff = Math.abs(curr - next);
            maxDiff = Math.max(maxDiff, diff);
        }
        return maxDiff;
    }
}