import java .util.*;

class Solution {
    public int findGCD(int[] nums) {
        IntSummaryStatistics values = Arrays.stream(nums).summaryStatistics();
        int max = values.getMax();
        int min = values.getMin();
        return gcd(max, min);
    }

    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}