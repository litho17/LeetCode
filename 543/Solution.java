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
    class Result {
        int diameter; // length of the longest path, i.e. diameter of the tree
        int left;     // length of the longest path from root to a node in left subtree
        int right;    // length of the longest path from root to a node in right subtree
        
        public Result(int diameter, int left, int right) {
            this.diameter = diameter;
            this.left = left;
            this.right = right;
        }
    }
    
    int max(int a, int b) {
        return Math.max(a, b);
    }
    
    int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        return helper(root).diameter;
    }
    
    Result helper(TreeNode root) {
        assert(root != null);
        if (root.left == null) {
            if (root.right == null) {
                return new Result(0, 0, 0);
            } else {
                Result r = helper(root.right);
                return new Result(max(r.diameter, r.left+1, r.right+1), 0, max(r.left, r.right)+1);
            }
        } else {
            if (root.right == null) {
                Result l = helper(root.left);
                return new Result(max(l.diameter, l.left+1, l.right+1), max(l.left, l.right)+1, 0);
            } else {
                Result l = helper(root.left);
                Result r = helper(root.right);
                return new Result(max(l.diameter, r.diameter, max(l.left, l.right)+2+max(r.left, r.right)), max(l.left, l.right)+1, max(r.left, r.right)+1);
            }
        }
    }
}

// Runtime: 1 ms, faster than 49.99% of Java online submissions for Diameter of Binary Tree.
// Memory Usage: 38.5 MB, less than 63.40% of Java online submissions for Diameter of Binary Tree.
