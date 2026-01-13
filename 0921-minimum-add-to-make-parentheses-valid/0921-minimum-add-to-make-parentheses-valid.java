class Solution {
    public int minAddToMakeValid(String s) {
        int openCount = 0;    
        int extraClose = 0;

        for (char curr : s.toCharArray()) {
            if (curr == '(') {
                openCount++;
            } else if (openCount > 0) {
                openCount--;
            } else {
                extraClose++;
            }
        }
        return openCount + extraClose;
    }
}
