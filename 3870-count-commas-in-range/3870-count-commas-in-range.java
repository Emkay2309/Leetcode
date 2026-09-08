class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        return 1+countCommas(n-1);
    }
}