class Solution {
    public int missingMultiple(int[] nums, int k) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        
        boolean[] present = new boolean[max + k + 1]; 
        for (int num : nums) {
            present[num] = true;
        }
        
        int multiple = k;
        while (multiple < present.length && present[multiple]) {
            multiple += k;
        }
        
        return multiple;
    }
}