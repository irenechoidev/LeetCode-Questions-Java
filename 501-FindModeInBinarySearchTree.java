class Solution {

    int maxCount = 0;

    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);

        // if there is more than one maxCount int the map
        List<Integer> result = new ArrayList<>();
        List<Integer> nodes = new ArrayList<>(map.keySet());
        for (int node : nodes) {
            if (map.get(node) == maxCount) {
                result.add(node);
            }
        }

        return convertListToArr(result);
    }

    private void dfs(TreeNode root, Map<Integer, Integer> map) {
        if (root == null)
            return;

        // count the values of nodes
        int count = map.getOrDefault(root.val, 0) + 1;
        // and update maxCount
        if (count > maxCount) {
            maxCount = count;
        }

        map.put(root.val, count);

        // process
        dfs(root.left, map);
        dfs(root.right, map);
    }

    private int[] convertListToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}