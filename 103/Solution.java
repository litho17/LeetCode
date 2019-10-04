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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        List<List<Integer>> ret = new LinkedList<>();
        if (root == null) return ret;
        boolean isLeft = true;
        stack2.push(root);
        while (!stack2.isEmpty() || !stack.isEmpty()) {
            List<Integer> level = new LinkedList<>();
            if (isLeft) {
                while (!stack2.isEmpty()) {
                    TreeNode top = stack2.pop();
                    level.add(top.val);
                    if (top.left != null) stack.push(top.left);
                    if (top.right != null) stack.push(top.right);
                }
                isLeft = false;
            }
            else {
                while (!stack.isEmpty()) {
                    TreeNode top = stack.pop();
                    level.add(top.val);
                    if (top.right != null) stack2.add(top.right);
                    if (top.left != null) stack2.add(top.left);
                }
                isLeft = true;
            }
            ret.add(level);
        }
        return ret;
    }
}

// Runtime: 1 ms, faster than 98.76% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
// Memory Usage: 36.1 MB, less than 99.04% of Java online submissions for Binary Tree Zigzag Level Order Traversal.
