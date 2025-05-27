class Solution {
    public int differenceOfSums(int n, int m) {
        int [] ans = new int [2];
        for(int i=1; i<=n ; i++) {
            if(i%m == 0) {
                ans[0] += i;
            }
            else {
                ans[1] += i;
            }
        }
        return ans[1]-ans[0];
    }
}