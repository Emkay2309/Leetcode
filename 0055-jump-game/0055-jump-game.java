class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReachable = 0;

        for(int i=0 ; i<n ; i++) {
            if(i > maxReachable) return false;
            int max = i+nums[i];
            maxReachable = Math.max(maxReachable , max);
        }
        return true;
    }
}