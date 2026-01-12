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
    HashMap<TreeNode, TreeNode> parent;

    public TreeNode getTarget(TreeNode root, TreeNode target) {
        if(root == null || root == target)  return root;

        if(root.left != null)   parent.put(root.left, root);
        if(root.right != null)   parent.put(root.right, root);
        
        TreeNode temp = getTarget(root.left, target);
        return temp != null? temp: getTarget(root.right, target);
    }


    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        TreeNode node = getTarget(root, target);
        
        if(node == null)    return new ArrayList<>();
        
        List<TreeNode> level = new ArrayList<>();
        HashSet<Integer> isVisited = new HashSet<>();
        int i=0;
        level.add(node);
        isVisited.add(node.val);
        
        while(i<k && !level.isEmpty()) {
            List<TreeNode> newLevel = new ArrayList<>();
            for(TreeNode item: level) {
                if(item.left != null && !isVisited.contains(item.left.val)) {
                    newLevel.add(item.left);
                    isVisited.add(item.left.val);
                }
                if(item.right != null && !isVisited.contains(item.right.val)) {
                    newLevel.add(item.right);
                    isVisited.add(item.right.val);
                }
                if(parent.containsKey(item) && !isVisited.contains(parent.get(item).val)) {
                    newLevel.add(parent.get(item));
                    isVisited.add(parent.get(item).val);
                }
            }
            level = newLevel;
            i++;
        }

        List<Integer> list = new ArrayList<>();
        for(TreeNode item: level) {
            list.add(item.val);
        }

        return list;
    }
}