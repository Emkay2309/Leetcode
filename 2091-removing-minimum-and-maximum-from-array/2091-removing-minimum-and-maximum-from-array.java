class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int minI = -1;
        int maxI = -1;

        for (int i = 0; i < n; i++) {
            if (nums[i] < min) {
                min = nums[i];
                minI = i;
            }

            if (nums[i] > max) {
                max = nums[i];
                maxI = i;
            }
        }

        // Make minI the smaller index
        if (minI > maxI) {
            int temp = minI;
            minI = maxI;
            maxI = temp;
        }

        // 1. Remove both from left
        int left = maxI + 1;

        // 2. Remove both from right
        int right = n - minI;

        // 3. Remove min from left and max from right
        int both = (minI + 1) + (n - maxI);

        return Math.min(left, Math.min(right, both));
    }
}