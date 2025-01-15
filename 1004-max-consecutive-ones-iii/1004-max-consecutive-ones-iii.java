class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length , ans = 0 , left = 0 , zero = 0;

        for(int right=0 ; right<n ; right++) {
            int curr = nums[right];

            if(curr == 0) {
                zero++;
            }

            while(zero > k) {
                if(nums[left++] == 0) {
                    zero--;
                }
            }
            ans = Math.max(ans , right-left+1);
        }
        return ans;
    }
}