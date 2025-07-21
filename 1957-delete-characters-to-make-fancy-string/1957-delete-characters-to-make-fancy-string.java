class Solution {
    public String makeFancyString(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();

        sb.append(s.charAt(0));
        int freq = 1;

        for(int i=1; i<n ; i++) {
            if(s.charAt(i) == sb.charAt(sb.length()-1) ) {
                freq++;
                if(freq < 3) {
                    sb.append(s.charAt(i));
                }
            }
            else {
                sb.append(s.charAt(i));
                freq = 1;
            }
        }
        return sb.toString();
    }
}