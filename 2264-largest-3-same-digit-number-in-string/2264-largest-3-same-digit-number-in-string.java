class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        String ans = "";
        int max = -1;

        for(int i=0; i<=n-3 ; i++) {
            if(num.charAt(i) == num.charAt(i+1) && num.charAt(i) == num.charAt(i+2)) {
                String curr = "" + num.charAt(i) + num.charAt(i) + num.charAt(i);
                int check = Integer.parseInt(curr);

                if(check > max) {
                    max = check;
                    ans = curr;
                }
            }
        }
        return ans;
    }
}