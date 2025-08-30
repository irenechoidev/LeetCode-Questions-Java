/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        
        return construct(postorder.length-1, 0, inorder.length-1, postorder, map);
    }

    public TreeNode construct(
        int postStart, 
        int inStart, 
        int inEnd,
        int[] postorder, 
        Map<Integer, Integer> map){
        
        if(postStart<0 || inStart>inEnd) return null;
        
        int val = postorder[postStart];
        TreeNode root = new TreeNode(val);
        int inIndex = map.get(val);
        int rightSize = inEnd-inIndex;

        root.left = construct(postStart-(rightSize)-1, inStart, inIndex-1, postorder, map);
        root.right = construct(postStart-1, inIndex+1, inEnd, postorder, map);
        
        return root;
    }
}

     