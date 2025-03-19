class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length , ans = 0;
        if(n < 3) return -1;

        for(int i=0 ; i<n-2 ; i++) {
            if(nums[i] == 0) {
                nums[i] = 1;
                ans++;

                nums[i+1] = (nums[i+1]==0) ? 1 : 0;
                nums[i+2] = (nums[i+2]==0) ? 1 : 0;
            }
        }

        return (nums[n-1]==0 || nums[n-2]==0) ? -1 : ans;
    }
}