class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            int curr = prices[i];
            int prev = prices[i-1];

            if (prev < curr) {
                int profit = curr - prev;
                ans += profit;
            }
        }
        return ans;
    }
}