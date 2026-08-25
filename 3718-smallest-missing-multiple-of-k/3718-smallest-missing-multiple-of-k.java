class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        
        int multiple = k;
        int index = 0;
        

        while (index < nums.length) {
            if (nums[index] == multiple) {
                multiple += k;

                while (index < nums.length && nums[index] == multiple - k) {
                    index++;
                }
            } 
            else if (nums[index] < multiple) {
                index++;
            } 
            else {
                return multiple;
            }
        }
        
        return multiple;
    }
}