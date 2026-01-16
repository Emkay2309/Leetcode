import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximizeSquareArea(int m, int n, int[] h, int[] v) {
        int mod = 1_000_000_007;
        Set<Integer> s1 = new HashSet<>();
        Set<Integer> s2 = new HashSet<>();
        Arrays.sort(h);
        Arrays.sort(v);

        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                s1.add(h[j] - h[i]);
            }
        }

        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                s2.add(v[j] - v[i]);
            }
        }

        long ans = 0;
        for (int i : s1) {
            if (s2.contains(i)) {
                long k = (long) i * i;
                ans = Math.max(ans, k);
            }
        }

        if (ans == 0) return -1;
        return (int) (ans % mod);
    }
}
