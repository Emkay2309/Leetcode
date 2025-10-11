class Solution {
    public int fib(int n) {
        int [] dp = new int [n+1];
        Arrays.fill(dp , -1);
        return dfs(n , dp);
    }

    public int dfs(int n , int [] dp) {
        
        if(n==0 || n==1) return n; //1

        if( dp[n] != -1) {
            return dp[n];
        }

        int one = dfs(n-1 , dp); 
        int two = dfs(n-2 , dp); 

        return dp[n] =  one+two; 
    }
}

