class Solution {
    public long sumAndMultiply(int n) {
        return sumAndMultiplyHelper(n, 0, 0, 1);
    }
    
    private long sumAndMultiplyHelper(int n, long x, long sum, long len) {
        // Base case: when n becomes 0
        if (n == 0) {
            return sum * x;
        }
        
        int digit = n % 10;
        
        // Calculate new x (only multiply len if digit != 0)
        long newX = digit * len + x;
        long newLen = (digit != 0) ? len * 10 : len;
        
        // Calculate new sum
        long newSum = sum + digit;
        
        // Recursive call with n/10
        return sumAndMultiplyHelper(n / 10, newX, newSum, newLen);
    }
}