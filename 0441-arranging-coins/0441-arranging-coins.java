class Solution {
    public int arrangeCoins(int n) {
        return find(0, 2147483647, n);
    }

    public int find(int lo, int hi, int target) {
        int ans = 0;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long sum = ((long) mid * (mid + 1)) / 2;
            if (sum <= target) {
                ans = mid;
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return (int) ans;
    }

}