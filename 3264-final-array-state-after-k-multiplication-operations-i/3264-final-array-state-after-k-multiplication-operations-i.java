class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n = nums.length;
        int check = k;

        for(int i=0 ; i<k ; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            for(int j=0 ; j<n ; j++) {
                if(nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if(index != -1) 
                nums[index] *= multiplier;
        }
        return nums;
    }
}