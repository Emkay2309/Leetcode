class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        for(int i=n-1 ; i>=0 ; i--) {
            int curr = digits[i];

            if(curr < 9) {
                digits[i] = curr+1; // digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int ans [] = new int [n+1];
        ans[0] = 1;
        return ans;
    }
}