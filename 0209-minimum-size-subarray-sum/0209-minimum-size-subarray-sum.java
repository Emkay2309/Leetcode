class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int maxIndex = -1;
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] == target) {
                return 1;
            }
        }
        
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        
        int i=0, j = 0;
        
        while(j < n) {
            sum += nums[j];
            
            while(sum >= target) {
                sum -= nums[i];
                ans = Math.min(j-i+1 , ans);
                i++;
            }
            j++;
        }
        
        if(ans == Integer.MAX_VALUE){
            return 0;
        }
        return ans;
           
    }
}