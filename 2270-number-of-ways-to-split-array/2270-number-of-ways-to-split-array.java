class Solution {
    public int waysToSplitArray(int[] nums) {
        int n  = nums.length;
        int ans = 0;
        long total = 0;
        long sum = 0;

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