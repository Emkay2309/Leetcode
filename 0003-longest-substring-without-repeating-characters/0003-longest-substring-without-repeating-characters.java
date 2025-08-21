class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length() , left = 0 ,  ans = 0;
        int [] freq = new int [128];

        for(int right=0 ; right<n ; right++) {
            int add = s.charAt(right);
            freq[add]++;

            if(freq[add] == 1) {
                ans = Math.max(ans , right-left+1);
            }
            else {
                while(freq[add] > 1  && left <= right) {
                    int remove = s.charAt(left);
                    freq[remove]--;
                    left++;
                }
            }
        }
        return ans;
    }
}