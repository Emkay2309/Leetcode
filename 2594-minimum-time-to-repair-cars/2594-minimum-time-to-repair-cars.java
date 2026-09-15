class Solution {
    public long repairCars(int[] ranks, int cars) {
        int minRank = Integer.MAX_VALUE;
        for (int rank : ranks) {
            minRank = Math.min(minRank, rank);
        }
        long left = 0;
        long right = (long) minRank * cars * cars;

        while (left < right) {
            long mid = left + (right - left) / 2;
            long repaired = 0;

            for (int rank : ranks) {
                repaired += Math.sqrt((double) mid / rank);
                if (repaired >= cars) {
                    break;
                }
            }
            
            if (repaired >= cars) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}