class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> result = new ArrayList<>();
        for (int i = left; i <= right; i++) {
            if (selfDividingNum(i)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean selfDividingNum(int num) {
        if (num == 0)
            return false;

        int temp = num;
        while (temp > 0) {
            int digit = temp % 10;

            if (digit == 0 || num % digit != 0) {
                return false;
            }

            temp = temp / 10;
        }

        return true;
    }
}