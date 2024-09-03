class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        boolean [] vis = new boolean [n];
        int group = 0;
        for(int i=0; i<n ; i++) {
            if(!vis[i]) {
                dfs(i,vis,stones);
                group++;
            }
        }
        return n - group;
    }

    public void dfs(int index , boolean [] vis , int [][] stones) {
        vis[index] = true; // vis[0] = true
        int r = stones[index][0]; // 0
        int c = stones[index][1]; // 1
        //Iterate on the complete stones matrix to check any row or col same
        for(int i=0; i<stones.length ; i++) {
            if((!vis[i] ) && (stones[i][0] == r || stones[i][1] == c)) {
                dfs(i , vis , stones);
            }
        }
    }
}