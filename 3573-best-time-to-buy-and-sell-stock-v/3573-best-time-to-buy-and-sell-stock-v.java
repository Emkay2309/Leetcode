class Solution {
    Long[][][] dp;
    
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        dp = new Long[n][k + 1][3];
        return dfs(0, 0, k, prices);
    }

    public long dfs(int index, int state, int transactions, int[] prices) {
        if (index == prices.length) {
            if (state == 0) return 0;
            return Integer.MIN_VALUE; // unfinished transaction is invalid
        }

        if (dp[index][transactions][state] != null) {
            return dp[index][transactions][state];
        }

        long notTake = dfs(index + 1, state, transactions, prices);
        long take = Integer.MIN_VALUE;

        if (transactions > 0) {
            if (state == 1) {
                // Sell today (complete normal transaction)
                take = prices[index] + dfs(index + 1, 0, transactions - 1, prices);
            } 
            else if (state == 2) {
                // Buy back today (complete short transaction)
                take = -prices[index] + dfs(index + 1, 0, transactions - 1, prices);
            }
            else { 
                // Start a new transaction
                long buy       = -prices[index] + dfs(index + 1, 1, transactions, prices); // normal buy
                long shortSell = prices[index] + dfs(index + 1, 2, transactions, prices); // short sell
                take = Math.max(buy, shortSell);
            }
        }

        return dp[index][transactions][state] = Math.max(notTake, take);
    }
}