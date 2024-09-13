class Solution {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        int n = s.length();
        int [] freq = new int [128];
        int left = 0;

        for(int right=0 ; right < n ; right++)  {
            int add = s.charAt(right);
            freq[add]++;

            if(freq[add] == 1)  {
                int len = right - left + 1;
                ans = Math.max( ans , len);
            }
            else {
                while(freq[add] > 1  && left < n)  {
                    int remove = s.charAt(left);
                    freq[remove]--;
                    left++;
                }
            }
        }
        return ans;
    }
}