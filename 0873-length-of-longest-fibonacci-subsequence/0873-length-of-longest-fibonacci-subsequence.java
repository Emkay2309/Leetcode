class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0 ; i<n ; i++) {
            map.put(arr[i] , i);
        }
        int [][] dp = new int [n+1][n+1];
        for(int a [] : dp) {
            Arrays.fill(a,-1);
        }
        int max = 0;

        for(int j=1 ; j<n ; j++) {
            for(int k=j+1 ; k<n ; k++) {
                int len = solve(j,k,arr,map,dp);
                if(len >= 3) {
                    max = Math.max(max , len);
                }
            }
        }
        return max;
    }

    public int solve(int j , int k , int [] arr , Map<Integer,Integer> map , int [][] dp) {
        if(dp[j][k] != -1) return dp[j][k];

        int target = arr[k]-arr[j];

        if(map.containsKey(target) && map.get(target)<j) {
            int i = map.get(target);
            return 1 + solve(i,j,arr,map,dp);
        }
        return 2;
    }
}