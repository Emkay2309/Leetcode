class Solution {
    public int numberOfWays(String corridor) {
        final int MOD = 1_000_000_007;
        int zero = 0, one = 0, two = 1;

        for (char thing : corridor.toCharArray()) {
            if (thing == 'S') {
                zero = one;
                int temp = one;
                one = two;
                two = temp;
            } else {
                two = (two + zero) % MOD;
            }
        }
        return zero;
    }
}