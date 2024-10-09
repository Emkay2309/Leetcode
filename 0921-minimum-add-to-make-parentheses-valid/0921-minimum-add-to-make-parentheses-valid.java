class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;
        int close = 0;
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                st.push(ch);
                open++;
            }
            else {
                close++;
                if(!st.isEmpty() && st.peek() == '(') {
                    st.pop();
                    open--;
                    close--;
                }
            }
        }

        return open+close;
    }
}