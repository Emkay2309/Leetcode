class Solution {
    int max = 0;
    int indexi=0;
    int indexj=0;
    public String longestPalindrome(String s) {
        max = 0;
        indexi=0;
        indexj=0;

        int n = s.length();

        for(int i=0 ; i<n ; i++ ) {
            check(i,i,n,s);
            check(i,i+1,n,s);
        }
        return s.substring(indexi , indexj);
    }

    public void check( int i , int j , int n , String s) {

        while( i>=0  && j<n  &&  s.charAt(i)==s.charAt(j)) {
            i--;
            j++;
        }
        i += 1;
        int len = j-i;

        if(len > max) {
            max = len;
            indexi= i;
            indexj = j;
        }

    }
}
