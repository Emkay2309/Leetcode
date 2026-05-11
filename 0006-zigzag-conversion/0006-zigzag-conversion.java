public class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        StringBuilder result = new StringBuilder();
        int cycleLen = 2 * numRows - 2;
        int n = s.length();
        
        for (int row = 0; row < numRows; row++) {
            for (int i = 0; i + row < n; i += cycleLen) {
                result.append(s.charAt(i + row));
                // Handle middle rows (non-top/bottom)
                if (row != 0 && row != numRows - 1 && i + cycleLen - row < n) {
                    result.append(s.charAt(i + cycleLen - row));
                }
            }
        }
        return result.toString();
    }
}