class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        
        // If k == n, there's only one subarray
        if (k == n) {
            int max = -1;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return max;
        }
        
        // Count frequencies
        int[] freq = new int[51];
        for (int num : nums) {
            freq[num]++;
        }
        
        int result = -1;
        
        // Check each number that appears
        for (int num = 0; num <= 50; num++) {
            if (freq[num] == 0) continue;
            
            if (freq[num] == 1) {
                // Find position of this single occurrence
                int pos = -1;
                for (int i = 0; i < n; i++) {
                    if (nums[i] == num) {
                        pos = i;
                        break;
                    }
                }
                
                // At ends: appears in exactly 1 subarray
                // In middle: appears in k subarrays (which is > 1 if k > 1)
                if (pos == 0 || pos == n - 1 || k == 1) {
                    result = Math.max(result, num);
                }
            }
        }
        
        return result;
    }
}