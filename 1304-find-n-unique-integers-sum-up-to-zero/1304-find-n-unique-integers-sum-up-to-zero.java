class Solution {
    public int[] sumZero(int n) {
        int val = n/2;

        int ans [] = new int [n];
        if(n%2==1) ans[0] = 0;
        int k=1;
        for(int i=1 ; i<=val ; i++) {
            ans[k++] = i;
            int j = i*-1;
            ans[k++] = j;
        }

        return ans;
    }
}