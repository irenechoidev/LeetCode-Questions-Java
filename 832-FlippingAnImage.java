class Solution {
    public int[][] flipAndInvertImage(int[][] image) {

        for (int[] arr : image) {
            int start = 0;
            int end = arr.length - 1;

            while (start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;

                start += 1;
                end -= 1;
            }

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 0) {
                    arr[i] = 1;
                } else {
                    arr[i] = 0;
                }
            }
        }

        return image;
    }
}