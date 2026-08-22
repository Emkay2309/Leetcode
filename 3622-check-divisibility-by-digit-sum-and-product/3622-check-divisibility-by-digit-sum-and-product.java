class Solution {

    public boolean checkDivisibility(int n) {
        int digitSum = sum(n);
        int digitProduct = product(n);

        return n % (digitSum + digitProduct) == 0;
    }

    public int sum(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;
            sum += digit;
            n = n / 10;
        }

        return sum;
    }

    public int product(int n) {
        int product = 1;

        while (n > 0) {
            int digit = n % 10;
            product *= digit;
            n = n / 10;
        }

        return product;
    }
}