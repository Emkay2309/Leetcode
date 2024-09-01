class Solution {
    public boolean isPowerOfTwo(int n) {
        int i=1;

        if(n==1) return true;

        while(i<31) {
            int power = (int)Math.pow(2,i);
            if(power == n) return true;
            i++;
        }
        return false;
    }
}