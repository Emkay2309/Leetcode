class Solution {
    public int maxScore(String s) {
        int n = s.length();
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<n-1 ; i++) {
            
            // left side count zero till i
            int zero = 0;
            for(int j=0 ; j<=i ; j++) {
                if(s.charAt(j) == '0') zero++;
            }

            //right side count one till n-1
            int one = 0;
            for(int j=i+1 ; j<n ; j++) {
                if(s.charAt(j) == '1') one++;
            }

            ans = Math.max(ans , zero+one);
        }
        return ans;
    }
}