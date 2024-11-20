class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return root;
            // key를 찾자. 
            // 1. key가 root.val 보다 크면 오른쪽에서,     
        else if (root.val > key) root.left = deleteNode(root.left, key);

            // 2. key가 root.val 보다 작으면 왼쪽에서
        else if (root.val < key) root.right = deleteNode(root.right, key);
        
            // 3. root.val == key 인 경우
        else {
        
                // 찾은 root가 left, right 모두 이 없으면 그냥 지우면 되고
            if (root.left == null && root.right == null ) return null;

                // left 만 있으면 
            if (root.left != null && root.right == null) return root.left;
                // right 만 있으면
            if (root.left == null && root.right != null) return root.right;

                // 그 root 가 left, right, 둘 다 있으면 
                // The maximum node from the left subtree (predecessor).
                //   -> [5,2,6,null,4,null,7]
            
                // TreeNode maxOnLeft = findMaxNode(root.left);
                // root.val = maxOnLeft.val;
                // root.left = deleteNode(root.left, root.val);

                // Or the minimum node from the right subtree (successor).
                //   -> [5,4,6,2,null,null,7]
            
            TreeNode minOnRight = findMinNode(root.right);
            root.val = minOnRight.val;
            root.right = deleteNode(root.right, root.val);
            
        }
        return root;
    }
        // private TreeNode findMaxNode(TreeNode root) {
        //     while (root.right != null) root = root.right;
        //     return root;
        // }
    
    private TreeNode findMinNode(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
        }

}
