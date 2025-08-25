class Solution {
    List<String> ans = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        
        solve(new StringBuilder() , n);
        return ans;
    }

    public void solve(StringBuilder curr , int n) {
        if(curr.length() == 2*n) {
            if(isValid(curr , n)) {
                ans.add(curr.toString());
            }
            return;
        }

        curr.append('(');
        solve(curr , n);
        curr.deleteCharAt(curr.length()-1);

        curr.append(')');
        solve(curr , n);
        curr.deleteCharAt(curr.length()-1);
    }

    public boolean isValid(StringBuilder str , int n) {
        int len = str.length();
        int open = 0, close = 0;

        for(char ch : str.toString().toCharArray()) {
            if(ch == '(') {
                open++;
            }
            else {
                close++;
            }
            if(close > open) {
                return false;
            }
        }

        return open == close;
    }
}