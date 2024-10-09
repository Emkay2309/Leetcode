class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int s=0,e=n-1;

        while( s <= e) {
            int mid = (s+e)/2;

            if(nums[mid] == target) {
                return mid;
            }


            if(nums[mid] > target) {
                ans = mid;
                e = mid-1;
            }
            else {
                s = mid+1;
            }
        }
        return ans;
    }
}