class Solution {
    public int climbStairs(int n) {
        if(n==0 || n==1 || n==2) return n;

        int prev = 1 , curr = 1;

        for(int i=2; i<=n ; i++) {
            int val = prev + curr;
            prev = curr;
            curr = val;
        }
        return curr;
    }

}