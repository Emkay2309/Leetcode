class Solution {
    public int countGoodRotations(int[] nums) {

        int n = nums.length;
        int half = n / 2;

        long totalSum = 0;
        long midSum = 0;

        for (int i = 0; i < n; i++) {

            totalSum += nums[i];

            if (i < half) {
                midSum += nums[i];
            }
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {

            if (midSum > totalSum - midSum) {
                ans++;
            }

            midSum -= nums[i];
            midSum += nums[(i + half) % n];
        }

        return ans;
    }
}