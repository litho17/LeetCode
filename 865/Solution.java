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
    class Pair {
        int depth;
        TreeNode ancestor;
        public Pair(int depth, TreeNode ancestor) {
            this.depth = depth;
            this.ancestor = ancestor;
        }
    }
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) return null;
        return helper(root).ancestor;
    }
    
    Pair helper(TreeNode root) {
        assert(root != null);
        if (root.left != null) {
            Pair l = helper(root.left);
            if (root.right != null) {
                Pair r = helper(root.right);
                if (l.depth == r.depth) {
                    return new Pair(l.depth+1, root);
                }
                else if (l.depth > r.depth) {
                    return new Pair(l.depth+1, l.ancestor);
                }
                else {
                    return new Pair(r.depth+1, r.ancestor);
                }
            }
            else {
                return new Pair(l.depth+1, l.ancestor);
            }
        }
        else {
            if (root.right != null) {
                Pair r = helper(root.right);
                return new Pair(r.depth+1, r.ancestor);
            }
            else {
                return new Pair(0, root);
            }
        }
    }
}

// Runtime: 1 ms, faster than 66.42% of Java online submissions for Smallest Subtree with all the Deepest Nodes.
// Memory Usage: 37.8 MB, less than 80.00% of Java online submissions for Smallest Subtree with all the Deepest Nodes.

// This is exactly the same problem as LeetCode 1123
