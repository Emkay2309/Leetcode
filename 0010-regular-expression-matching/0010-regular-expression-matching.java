class Solution {
    Boolean [][] dp;
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i=0 , j=0;
        dp = new Boolean [n+1][m+1];
        return dfs(0 , 0 , n , m , s , p);
    }

    public boolean dfs(int i , int j , int n , int m , String str , String pat) {
        if(dp[i][j] != null) return dp[i][j];

        boolean ans;

        if(j >= pat.length()) {
            ans = (i == n);
        }
        else {
            boolean isFirstCharSame = i<n && (str.charAt(i)==pat.charAt(j) || pat.charAt(j)=='.');
            // * cases in if
            if( j+1<m && pat.charAt(j+1) == '*') {
                //use * or skip cases
                boolean skip                  =   dfs(i , j+2 , n , m , str , pat);
                boolean use = isFirstCharSame &&  dfs(i+1 , j , n , m , str , pat);

                ans = skip || use;
            }
            else { // simple case
                ans = isFirstCharSame && dfs(i+1 , j+1 , n , m , str , pat);
            }
        }
        return dp[i][j] = ans;
    }
}