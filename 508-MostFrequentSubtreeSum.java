class Solution {

    Map<Integer, Integer> map = new HashMap<>();
    int max = Integer.MIN_VALUE;

    public int[] findFrequentTreeSum(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        dfs(root);

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (max == entry.getValue()) {
                list.add(entry.getKey());
            }
        }

        return listToArr(list);
    }

    private int dfs(TreeNode root) {
        if (root == null)
            return 0;

        int sum = root.val + dfs(root.left) + dfs(root.right);

        map.put(sum, map.getOrDefault(sum, 0) + 1);
        max = Math.max(max, map.get(sum));

        return sum;
    }

    private int[] listToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        int idx = 0;
        for (int i : list) {
            arr[idx] = i;
            idx += 1;
        }
        return arr;
    }
}
