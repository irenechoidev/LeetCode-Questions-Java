class Solution {
    public int singleNonDuplicate(int[] nums) {
        // find a non-pair
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // nums.length 는 항상 odd number
            // nums[mid] == nums[mid-1] 일때
            if (mid > 0 && nums[mid] == nums[mid - 1]) {

                // 만약 mid-1 이 odd 면
                if ((mid - 1) % 2 != 0) {
                    // ordinal number 로는 even (0-indexed 니까)
                    // mid-1 의 왼쪽에 odd numbers of elements들이 있다는 뜻이니까
                    // left 에서 찾고
                    end = mid - 1;

                } else {
                    start = mid + 1;
                }

                // nums[mid] == nums[mid+1] 일때
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {

                // 만약 if mid+1 이 odd 면
                if ((mid + 1) % 2 != 0) {
                    // ordinal number 로는 even (0-indexed 니까)
                    // mid+1 의 오른쪽에 odd numbers of elements들이 있다는 뜻이니까
                    // right 에서 찾고
                    start = mid + 1;

                } else {
                    end = mid - 1;
                }
            } else {
                return nums[mid];
            }
        }

        // Constraints:
        // 0 <= nums[i] <= 105
        return -1;
    }
}
