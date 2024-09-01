class Solution {
    public int countSubstrings(String s) {
        int n = s.length();
        int ans = 0;

        for(int i=0 ; i<n ; i++) {
            for(int j=i ; j<n ; j++) {
                if(check( i , j , s)) ans++;
            }
        }
        return ans;
    }

    public boolean check(int i, int j , String s) {
        if(i > j) return true;

        if(s.charAt(i) == s.charAt(j)) {
            return check(i+1 , j-1 , s);
        }
        return false;
    }
}