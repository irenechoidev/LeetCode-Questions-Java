class Solution {
    public int[] decompressRLElist(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 1; i += 2) {
            int freq = nums[i];
            int val = nums[i + 1];
            for (int j = 0; j < freq; j++) {
                list.add(val);
            }
        }
        return listToArr(list);
    }

    private int[] listToArr(List<Integer> list) {
        int[] res = new int[list.size()];
        int idx = 0;
        for (int l : list) {
            res[idx] = l;
            idx += 1;
        }
        return res;
    }
}