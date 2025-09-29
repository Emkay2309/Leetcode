class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();

        for(int i=1 ; i<=9 ; i++) {
            solve(i , n , ans);
        }
        return ans;
    }

    public void solve(int num , int n , List<Integer> ans) {
        if(num > n) return;
        ans.add(num);

        for(int add=0 ; add<=9 ; add++) {
            int newNum = (num*10)+add;
            if(newNum > n) return;
            solve(newNum , n , ans);
        }
    }
}
