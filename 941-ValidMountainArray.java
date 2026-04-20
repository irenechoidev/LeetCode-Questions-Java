class Solution {
    public boolean validMountainArray(int[] arr) {
        int peakIdx = 0;

        while (peakIdx + 1 < arr.length && arr[peakIdx] < arr[peakIdx + 1]) {
            peakIdx += 1;
        }

        if (peakIdx == 0 || peakIdx == arr.length - 1) {
            return false;
        }

        while (peakIdx + 1 < arr.length && arr[peakIdx] > arr[peakIdx + 1]) {
            peakIdx += 1;
        }

        return peakIdx == arr.length - 1;
    }
}
