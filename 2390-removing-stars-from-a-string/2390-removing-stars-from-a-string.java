class Solution {
    public String removeStars(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(Character curr : s.toCharArray()) {
            if(curr.equals('*')) {
                st.pop();
            }
            else {
                st.add(curr);
            }
        }

        String ans ="";
        while(!st.isEmpty()) {
            ans = st.pop() + ans;
        }
        return ans;
    }
}