class Solution {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for(String op : operations) {
            if(op.equals("--X") || op.equals("X--")) {
                ans -= 1;
            }
            else {
                ans += 1;
            }
        }
        return ans;
    }
}