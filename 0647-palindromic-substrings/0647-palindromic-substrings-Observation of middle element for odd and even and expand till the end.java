class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        boolean [][] dp = new boolean [n][n];

        for(int len=1 ; len<=n ; len++) {
            for(int i=0 ; i+len-1 < n  ; i++) {
                int j = i+len-1;

                //cases
                //if len == 1
                if(i == j) {
                    dp[i][j] = true;
                }
                else if(i+1 == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                }
                else {
                    boolean curr = s.charAt(i) == s.charAt(j);
                    boolean curr1 = dp[i+1][j-1];
                    dp[i][j] = curr && curr1;
                }


                if(dp[i][j] == true) {
                    ans++;
                }
            }
        }
        return ans;
    }
}