/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
    public void serializeTree(TreeNode root, StringBuilder tree) {
        if(root == null) {
            tree.append("null,");
            return;
        }
        tree.append(root.val+",");
        serializeTree(root.left, tree);
        serializeTree(root.right, tree);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)    return null;
        StringBuilder tree = new StringBuilder();
        serializeTree(root, tree);
        return String.valueOf(tree);
    }

    int index = 0;
    public TreeNode deserializeTree(String[] nodes) {
        if(index > nodes.length-1 || nodes[index].equals("null")) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(nodes[index++]));
        root.left = deserializeTree(nodes);
        root.right = deserializeTree(nodes);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)    return null;
        String[] nodes = data.split(",");
        return deserializeTree(nodes);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));