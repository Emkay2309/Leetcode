class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int[] pf = new int[n];
        int[] last = new int[n];
        
        // prefix: consecutive 1s ending at i
        for(int i=0; i<n; i++) {
            if(nums[i] == 1) {
                pf[i] = (i > 0 ? pf[i-1] : 0) + 1;
            } else {
                pf[i] = 0;
            }
        }
        
        // suffix: consecutive 1s starting at i
        for(int i=n-1; i>=0; i--) {
            if(nums[i] == 1) {
                last[i] = (i < n-1 ? last[i+1] : 0) + 1;
            } else {
                last[i] = 0;
            }
        }
        
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                int left = (i > 0) ? pf[i-1] : 0;
                int right = (i < n-1) ? last[i+1] : 0;
                ans = Math.max(ans, left + right);
            }
        }
        
        // Edge cases
        if(ans == 0) {
            boolean allOnes = true, allZeros = true;
            for(int x : nums) {
                if(x == 0) allOnes = false;
                if(x == 1) allZeros = false;
            }
            if(allOnes) return n-1;  // all 1s → must delete one
            if(allZeros) return 0;   // all 0s → no 1s at all
        }
        
        return ans;
    }
}
