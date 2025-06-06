class Solution {
    public void sortColors(int[] nums) {
        int n = nums.length;

        int s = 0;
        int m = 0;
        int e =  n-1;

        while(m <= e) {
            if(nums[m] == 0) {
                swap(nums , s , m);
                s++;
                m++;
            }
            else if(nums[m] == 1) {
                m++;
            }
            else if(nums[m] == 2) {
                swap(nums , m , e);
                e--;
            }
        }
    }

    public void swap(int [] nums , int s , int e) {
        int temp = nums[s];
        nums[s] = nums[e];
        nums[e] = temp;
    }
}