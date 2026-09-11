class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int evenIndex = 0;
        int currentIndex = 0;

        for (int num : nums) {
            if (num % 2 == 0) {
                swap(nums, currentIndex, evenIndex);
                evenIndex++;
            }
            currentIndex++;
        }
        return nums;
    }

    public void swap(int [] arr , int l , int r) {
        int temp =  arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}