class Solution {
    public int bulbSwitch(int n) {
        return countSquares(n, 1);
    }
    private int countSquares(int n, int k) {
        if (k * k > n)  return 0;
        return 1 + countSquares(n, k + 1);
    }
}
