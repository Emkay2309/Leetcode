class Solution {
    public int maxOperations(String s) {
        int count=0, n=s.length(), count1=(s.charAt(0)-'0');
        for(int i=1; i<n; i++){
            final int x = s.charAt(i)-'0';
            count1+=x;
            count += (x==0 && s.charAt(i-1)-'0'==1) ? count1 : 0;
        }
        return count;
    }
}