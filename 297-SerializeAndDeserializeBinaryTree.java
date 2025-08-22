public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        constructString(root, sb);

        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void constructString(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("#");
            sb.append(",");
        } else {
            sb.append(root.val);
            sb.append(",");
            constructString(root.left, sb);
            constructString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");

        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }

        return constructTree(list);
    }

    int idx = 0;

    private TreeNode constructTree(List<String> list) {
        String val = list.get(idx);
        idx += 1;

        if (val.equals("#")) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = constructTree(list);
            root.right = constructTree(list);

            return root;
        }
    }
}
