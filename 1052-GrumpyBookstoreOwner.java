class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int satisfied = 0;

        for (int i = 0; i < grumpy.length; i++) {
            if (grumpy[i] == 0) {
                satisfied += customers[i];
            }
        }

        int start = 0;
        int end = 0;
        int currExtra = 0;
        int maxExtra = 0;

        while (end < grumpy.length) {
            if (grumpy[end] == 1) {
                currExtra += customers[end];
            }

            while (end - start + 1 >= minutes) {
                maxExtra = Math.max(maxExtra, currExtra);

                if (grumpy[start] == 1) {
                    currExtra -= customers[start];
                }
                start += 1;

            }
            end += 1;
        }
        return satisfied + maxExtra;
    }
}