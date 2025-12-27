class Solution {
    public int arrangeCoins(int n) {
        return dfs(n, 1, 0);
    }
    public int dfs(int blocksLeft, int blocksNeededForThisStep, int stepsBuilt) {
        if (blocksLeft < blocksNeededForThisStep) return stepsBuilt;
        
        return dfs(blocksLeft - blocksNeededForThisStep, blocksNeededForThisStep + 1, stepsBuilt + 1);
    }
}