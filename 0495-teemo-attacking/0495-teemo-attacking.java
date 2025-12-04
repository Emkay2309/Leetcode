class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int n = timeSeries.length;
        if (n == 0) return 0;
        int total = 0;

        for (int i = 0; i < n - 1; ++i) {
            int currDifference = timeSeries[i + 1] - timeSeries[i];
            total += Math.min(currDifference , duration);
        }
        return total + duration;
    }
}