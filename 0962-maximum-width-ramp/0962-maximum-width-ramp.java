class Solution {
    public int maxWidthRamp(int[] nums) {
        int n = nums.length;
        int [] maxArr = new int [n];
        int max = -1;
        for(int i=n-1 ; i>=0 ; i--) {
            int val = nums[i];
            max = Math.max(max , val);
            maxArr[i] = max;
        }

        int ans = 0;
        int i=0;
        int j=0;

        while( j < n) {
            while(i < j  &&  nums[i] > maxArr[j]) {
                i++;
            }
            ans = Math.max(ans , j-i);
            j++;
        }

        return ans;

    }
}