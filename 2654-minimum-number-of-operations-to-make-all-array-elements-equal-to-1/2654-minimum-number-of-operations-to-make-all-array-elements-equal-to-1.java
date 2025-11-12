class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        int countOnes = 0;
        
        // Count existing ones
        for (int num : nums) {
            if (num == 1) countOnes++;
        }
        
        // If we already have at least one 1, we can convert others
        if (countOnes > 0) {
            return n - countOnes;
        }
        
        // Find the smallest subarray that can produce GCD = 1
        int minLength = Integer.MAX_VALUE;
        
        for (int i = 0; i < n; i++) {
            int currentGCD = nums[i];
            for (int j = i; j < n; j++) {
                currentGCD = gcd(currentGCD, nums[j]);
                if (currentGCD == 1) {
                    minLength = Math.min(minLength, j - i + 1);
                    break;
                }
            }
        }
        
        if (minLength == Integer.MAX_VALUE) return -1;
        
        // Operations = (minLength - 1) to create first 1 + (n - 1) to convert rest
        return minLength - 1 + n - 1;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}