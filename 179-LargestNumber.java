class Solution {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
        String[] strs = new String[nums.length];

        for (int i = 0; i < strs.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));

        for (String s : strs) {
            System.out.println(s);
            res.append(s);
        }

        return res.charAt(0) == '0' ? "0" : res.toString();
    }
}
