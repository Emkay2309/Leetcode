class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;

        boolean firstMatch = (s.length() > 0 &&  (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.') );

        if (p.length() >= 2 && p.charAt(1) == '*') {
            boolean skipXStar    = isMatch(s, p.substring(2));
            boolean useXStar  =  firstMatch && isMatch(s.substring(1), p);
            return skipXStar || useXStar;
        }     
        return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
}
