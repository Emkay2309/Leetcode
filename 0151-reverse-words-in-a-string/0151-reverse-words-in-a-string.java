class Solution {
    public String reverseWords(String s) {
        String [] check = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder("");

        for(int i=check.length-1 ; i>=0 ; i--) {
            String a = check[i];
            sb.append(a);
            sb.append(' ');
        }

        return sb.toString().trim();
    }
}