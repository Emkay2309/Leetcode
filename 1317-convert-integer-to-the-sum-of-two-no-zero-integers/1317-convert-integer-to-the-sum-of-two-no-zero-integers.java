class Solution {
    public int[] getNoZeroIntegers(int n) {
        if((n-1) % 10 != 0)   return new int []{1,n-1};
        return new int [] {2,n-2};
    }
}