class Solution {
    public int numComponents(ListNode head, int[] nums) {
        int result = 0;
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        while (head != null) {
            if (set.contains(head.val) &&
                    (head.next == null || !set.contains(head.next.val))) {
                result += 1;
            }

            head = head.next;
        }
        return result;
    }
}