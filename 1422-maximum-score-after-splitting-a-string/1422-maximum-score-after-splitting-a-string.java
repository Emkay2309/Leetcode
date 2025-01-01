class Solution {
    public int maxScore(String s) {
        int ans = 0 , zero = 0 , one = 0 , totalOne = 0 , n = s.length();

        for(char ch : s.toCharArray()) {
            if(ch == '1') totalOne++;
        }

        for(int i=0 ; i<n-1 ; i++) {
            if(s.charAt(i) == '1') one++;
            else zero++;

            int rightOne = totalOne - one;
            int curr = zero + rightOne;

            ans = Math.max(ans , curr);
        }

        return ans;
    }
}