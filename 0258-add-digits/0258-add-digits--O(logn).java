class Solution {
    int sum = 0;
    public int addDigits(int num) {
        while(countOfDigits(num) > 1) {
            num = sum;
        }
        return sum;
    }

    public int countOfDigits(int num) {
        int count = 0;
        sum = 0;

        while(num != 0) {
            sum += num%10;
            num /= 10;
            count++;
        } 
        return count;
    }
}