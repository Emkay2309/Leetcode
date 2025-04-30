class Solution {
    public int findNumbers(int[] nums) {
        
        return (int) Arrays.stream(nums)
            .mapToObj(Integer::toString)
            .filter(s -> s.length() % 2 == 0)
            .count();
    }
}