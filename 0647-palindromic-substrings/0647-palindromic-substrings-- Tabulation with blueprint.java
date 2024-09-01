class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        Boolean [][] dp = new Boolean [n][n];
        for(Boolean [] a : dp) {
            Arrays.fill(a , null);
        }

        for(int i=0 ; i<n ; i++) {
            for(int j=i ; j<n ; j++) {
                if(check( i , j , s , dp)) ans++;
            }
        }
        return ans;
    }

    public boolean check(int i, int j , String s , Boolean [][] dp) {
        if(i > j) return true;

        if(dp[i][j] != null) return dp[i][j];

        if(s.charAt(i) == s.charAt(j)) {
            return dp[i][j] = check(i+1 , j-1 , s , dp);
        }
        return  dp[i][j] = false;
    }
}