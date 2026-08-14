class Solution {
    public int maximumLengthSubstring(String s) {
        int [] freq = new int [26];
        int left = 0;
        int ans = 0;

        for(int right=0 ; right<s.length() ; right++) {
            int curr = s.charAt(right) - 'a';
            freq[curr]++;

            while(freq[curr] > 2) {
                int ch = s.charAt(left) - 'a';
                freq[ch]--;
                left++;
            }
            ans = Math.max(ans , right-left+1);
        }
        return ans;
    }
}