class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int n = nums.length ,  even = 0 , odd = 0;

        while(odd < n) {
            int curr = nums[odd];

            if(curr%2==0) {
                swap(nums , odd , even);
                even++;
            } 
            odd++;
        }

        return nums;
    }

    public void swap(int [] arr , int l , int r) {
        int temp =  arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}