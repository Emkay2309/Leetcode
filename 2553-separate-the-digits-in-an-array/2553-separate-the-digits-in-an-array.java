class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int num : nums) {
            getDigits(resultList, num);
        }
        return resultList.stream().mapToInt(i -> i).toArray();
    }

    private void getDigits(ArrayList<Integer> digits, int num) {
        if (num < 10) {
            digits.add(num);
            return;
        }
        getDigits(digits, num / 10);
        digits.add(num % 10);
    }
}