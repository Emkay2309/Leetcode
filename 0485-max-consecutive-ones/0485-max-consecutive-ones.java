class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int ans = 0;
        int zero = 0;

        for(int i=0 ; i<n ; i++) {
            if(nums[i] == 0) {
                ans = Math.max(ans , i-zero);
                zero = i+1;
            }
        } 
        return Math.max(ans , n-zero);
    }
}