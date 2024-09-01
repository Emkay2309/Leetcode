class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if(original.length != m*n) return new int [][] {};
        int [][] ans = new int [m][n];
        for(int i=0 ; i<original.length ; i++) {
            int row = i/m;
            int col = i%m;

            ans[row][col] = original[i];
        }
        return ans;
    }
}