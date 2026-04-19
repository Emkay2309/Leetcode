class Solution {
    public int maxDistance(int[] A, int[] B) {
        int i = 0;
        int j = 0;
        int maxDist = 0;
        
        while (i < A.length && j < B.length) {
            if (A[i] <= B[j]) {
                maxDist = Math.max(maxDist, j - i);
                j++;
            } else {
                i++;
            }
        }
        
        return maxDist;
    }
}