class Solution {
    public int totalFruit(int[] fruits) {
        int lastFruit = 0;
        int secondLastFruit = 0;

        int lastFruitCount = 0;
        int currentCount = 0;
        int max = 0;

        for (int f : fruits) {
            if (f == lastFruit || f == secondLastFruit) {
                currentCount += 1;
            } else {
                currentCount = lastFruitCount + 1;
            }

            if (f == lastFruit) {
                lastFruitCount += 1;
            } else {
                lastFruitCount = 1;
            }

            if (f != lastFruit) {
                secondLastFruit = lastFruit;
                lastFruit = f;
            }

            max = Math.max(max, currentCount);
        }
        return max;
    }
}
