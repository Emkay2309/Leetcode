class Solution {
    public int search(int[] nums, int target) {
        int ans = -1;
        int n = nums.length;

        int left = 0;
        int right = n-1;

        while(left <= right)  {
            int mid = (left+right)/2;

            if(nums[mid] == target) {
                return mid;
            }

            // Left sorted or not 
            if(nums[left] <= nums[mid])  {
                //If target is present or not
                if(nums[left] <= target  &&  target <= nums[mid]) {
                    right = mid-1;
                }
                else {
                    left = mid+1;
                }
            }
            //Right sorted or not
            else if(nums[mid] <= nums[right])  {
                //If target present or not
                if(nums[mid] <= target  &&  target <= nums[right]) {
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }
        }
        return ans;
    }
}