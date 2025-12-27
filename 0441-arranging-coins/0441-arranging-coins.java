class Solution {
    public int arrangeCoins(int n) {
        return dfs(n,1,0);
    }
    public int dfs(int blocks , int currSteps , int height) {
        if(blocks < currSteps) return height;
        return dfs(blocks-currSteps , currSteps+1 , height+1);
    }
}