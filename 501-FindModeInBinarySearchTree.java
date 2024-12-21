class Solution {

    int maxCount = 0;
    Map<Integer, Integer> map = new HashMap<>();
    
    public int[] findMode(TreeNode root) {
       
        preorderTraversalAndCount(root);

        // if there is more than one maxCount int the map
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {     
            if (entry.getValue() == maxCount) {
                result.add(getKey());
            }
        }

        return convertListToArr(result);
    }

    private void preorderTraversalAndCount(TreeNode root) {
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
        preorderTraversalAndCount(root.left);
        preorderTraversalAndCount(root.right);
    }

    private int[] convertListToArr(List<Integer> list) {
        int[] arr = new int[list.size()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
