class Solution {
    public boolean isPowerOfFour(int n) {
        if(n <= 0) return false;

        double val = Math.log10(n)/Math.log10(4);
        return val == (int)val;
    }
}