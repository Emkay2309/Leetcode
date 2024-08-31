class Solution {
    public int minCost(int n, int[] cuts) {

        int m = cuts.length;
        if (m == 1)
            return n;

        ArrayList<Integer> stick = new ArrayList<>();
        stick.add(0);
        Arrays.sort(cuts);
        for (int a : cuts) {
            stick.add(a);
        }
        stick.add(n);

        int[][] dp = new int[102][102];
        for (int[] a : dp) {
            Arrays.fill(a, -1);
        }

        return dfs(0, stick.size() - 1, stick, dp);
    }

    public int dfs(int left, int right, ArrayList<Integer> stick, int[][] dp) {
        if (right - left < 2)
            return 0;

        if (dp[left][right] != -1)
            return dp[left][right];

        int ans = Integer.MAX_VALUE;

        for (int cut = left + 1; cut <= right - 1; cut++) {

            int curr = (stick.get(right) - stick.get(left)) + dfs(left, cut, stick, dp)
                    + dfs(cut, right, stick, dp);

            ans = Math.min(ans, curr);
        }
        return dp[left][right] = ans;
    }
}