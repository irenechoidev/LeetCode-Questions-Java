class Solution {
    public boolean canThreePartsEqualSum(int[] arr) {
        int sum = 0;
        for (int i : arr) {
            sum += i;
        }

        int avg = sum / 3;

        int count = 0;
        int sectionSum = 0;

        for (int i : arr) {
            sectionSum += i;
            if (sectionSum == avg) {
                count += 1;
                sectionSum = 0;
            }
        }

        return count >= 3 && sum % 3 == 0;
    }
}