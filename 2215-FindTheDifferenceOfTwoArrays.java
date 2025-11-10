class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> result = new ArrayList<>();

        Set<Integer> nums1ToSet = makeSet(nums1);
        Set<Integer> nums2ToSet = makeSet(nums2);

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();

        for (int n : nums1ToSet) {
            if (!nums2ToSet.contains(n))
                list1.add(n);
        }

        for (int n : nums2ToSet) {
            if (!nums1ToSet.contains(n))
                list2.add(n);
        }

        result.add(list1);
        result.add(list2);

        return result;
    }

    private Set<Integer> makeSet(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }
        return set;
    }
}