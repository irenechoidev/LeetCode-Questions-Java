class Solution {
    public int findSpecialInteger(int[] arr) {

        if (arr.length == 0)
            return arr[0];
        int count = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] == arr[i]) {
                count += 1;
                if (count > arr.length / 4) {
                    return arr[i];
                }

            } else {
                count = 1;
            }
        }

        return ' ';
    }
}