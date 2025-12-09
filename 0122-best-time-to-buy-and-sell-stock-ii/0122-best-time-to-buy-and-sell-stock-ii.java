class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int ans = 0;
        int [][] dp = new int [n][2];
        for(int [] a : dp) {
            Arrays.fill(a , -1);
        }
        int buy = 0;

        return dfs(0 , n , buy , prices , dp);
    }
    public int dfs(int i , int n , int buy , int [] arr , int [][] dp) {
        if(i >= n ) return 0;

        if(dp[i][buy] != -1) return dp[i][buy];

        int profit = 0;

        //if you can buy acc to flag
        if(buy == 0) {
            int currBuy = -arr[i] + dfs(i+1,n,1,arr,dp);
            int notBuy = dfs(i+1 , n , 0 , arr , dp);

            profit = Math.max(currBuy , notBuy);
        }
        //acc to flag you have to sell
        else {
            int sell = arr[i] + dfs(i+1 , n , 0 , arr , dp);
            int notSell = dfs(i+1 , n , 1 , arr , dp);

            profit = Math.max(sell , notSell);
        }
        return dp[i][buy] = profit;
    }
}