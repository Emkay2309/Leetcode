class Solution {
    int count = 0;   
    int ans = -1;    

    public int findKthNumber(int n, int k) {
        for (int i = 1; i <= 9; i++) {  
            dfs(i, n, k);
            if (ans != -1) break;     
        }
        return ans;
    }

    private void dfs(long num, int n, int k) {
        if (num > n || ans != -1) return;

        count++;

        if (count == k) {
            ans = (int) num;
            return;
        }

        for (int i = 0; i <= 9; i++) {
            dfs(num * 10 + i, n, k);
            if (ans != -1) return;  
        }
    }
}
