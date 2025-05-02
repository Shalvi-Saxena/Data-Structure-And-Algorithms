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

    public List<String> preOrder(TreeNode root, List<String> arr) {
        if(root == null) {
            arr.add("null");
            return arr;
        }
        arr.add(String.valueOf(root.val));
        arr = preOrder(root.left, arr);
        arr = preOrder(root.right, arr);
        return arr;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> tree = preOrder(root, new ArrayList<>());
        System.out.println("tree = "+ String.join(",",tree));
        return String.join(",",tree);
    }

    int index;

    public TreeNode createTree(String[] dataArr) {
        if(dataArr[index].compareTo("null") == 0) {
            index++;
            return null;
        }
        TreeNode root = new TreeNode(Integer.valueOf(dataArr[index++]));
        root.left = createTree(dataArr);
        root.right = createTree(dataArr);
        return root;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        index = 0;
        String[] dataArr = data.split(",");
        
        return createTree(dataArr);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));