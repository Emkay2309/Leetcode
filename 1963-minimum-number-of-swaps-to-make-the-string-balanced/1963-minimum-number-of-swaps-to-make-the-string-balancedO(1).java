class Solution {
    public int minSwaps(String s) {
        int ans = 0;
        int n = s.length();

        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()) {
            if(ch == '[') {
                st.push(ch);
            }
            else {
                if(!st.isEmpty() && st.peek() == '[') {
                    st.pop();
                }
                else {
                    ans++;
                }
            }
        }

        return (ans+1)/2;
    }
}