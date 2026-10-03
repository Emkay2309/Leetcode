class Solution {
    public int longestValidParentheses(String s) {
        
        if(s==null || s.length()==1) return 0;
        
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        
        for(int i=0 ; i<s.length() ; i++) {
            char ch = s.charAt(i);
            
            if(ch == '(') {
                stack.push(i);
            }
            else {
                stack.pop();
                if(!stack.isEmpty()) {
                    int len = i - stack.peek();
                    ans = Math.max(len,ans);
                }
                else {
                    stack.push(i);
                }
            }
        }  
        return ans;
    }
}