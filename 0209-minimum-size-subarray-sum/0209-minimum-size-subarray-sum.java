class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;

        int i=0 , j=0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;

        while(j < n) {
            int add = nums[j];
            if(add == target) {
                return 1;
            }

            sum += add;

            while( sum >= target) {
                int sub = nums[i];
                sum -= sub;
                ans = Math.min(ans , j-i+1);
                i++;
            }
            j++;
        }
        
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}