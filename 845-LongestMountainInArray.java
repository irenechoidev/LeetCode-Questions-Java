class Solution {
    public int longestMountain(int[] arr) {
        if (arr.length < 3)
            return 0;

        int res = 0;

        for (int i = 1; i < arr.length - 1; i++) {

            // check arr[i] if it matches the condition of mountain
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {

                // expand
                int left = i;
                int right = i;
                while (left > 0 && arr[left] > arr[left - 1]) {
                    left -= 1;
                }

                while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    right += 1;
                }

                // update longest
                res = Math.max(res, right - left + 1);
            }
        }

        return res;

    }
}