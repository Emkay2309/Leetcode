class Solution {
    public int waysToSplitArray(int[] nums) {
        int n  = nums.length;
        int ans = 0;
        int total = 0;
        int sum = 0;

        for(int a : nums) {
            total += a;
        }

        for(int i=0 ; i<n-1 ; i++) {
            sum += nums[i];

            if(sum >= total-sum) ans++;
        }
        return ans;
    }
}