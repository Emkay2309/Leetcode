class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;

        while (empty >= numExchange) {
            int newBottles = empty / numExchange; // how many new bottles we get
            total += newBottles;
            empty = empty % numExchange + newBottles; // remaining + new empties
        }
        return total;
    }
}
