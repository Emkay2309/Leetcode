class Solution {
    public boolean check(int[] nums) {
        
        int n = nums.length;

        int rotation = 0;

        for(int i=0 ; i<n-1 ; i++) {
            if(nums[i] > nums[i+1]) {
                rotation++;

                if(rotation > 1) {
                    return false;
                }
            }
        }

        if(rotation == 1) {
                return nums[n-1] <= nums[0];
        }

        return true;
    }
}
