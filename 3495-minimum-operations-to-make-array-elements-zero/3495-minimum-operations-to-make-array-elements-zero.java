class Solution {
    public long minOperations(int[][] queries) {
        long steps = 0;
        long[] power = new long[20];
        power[0] = 1;
        for (int i = 1; i < 20; i++) {
            power[i] = power[i - 1] * 4;
        }
        int n = queries.length;

        for (int i = 0; i < n; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            long total = 0;

            for (int j = 1; j < 20; j++) {
                long left = power[j - 1];
                long right = power[j] - 1;

                long from = Math.max(l, left);
                long to = Math.min(r, right);
                if (from <= to) {
                    total += (to - from + 1) * j;
                }
            }
            steps += (total + 1) / 2;
        }
        return steps;
    }
}