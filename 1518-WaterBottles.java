class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int emptyBottles = numBottles;

        while (emptyBottles >= numExchange) {
            int newBottles = emptyBottles / numExchange;
            int remainingEmpty = emptyBottles % numExchange;

            result += newBottles;
            emptyBottles = newBottles + remainingEmpty;
        }

        return result;
    }
}