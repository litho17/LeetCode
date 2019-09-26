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
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    boolean isValid;
    
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;
        isValid = true;
        helper(root);
        return isValid;
    }
    
    // Return the last visited node's value
    Pair helper(TreeNode root) {
        if (root.left == null) {
            if (root.right == null) {
                return new Pair(root.val, root.val);
            }
            else {
                Pair right = helper(root.right);
                if (!(root.val < right.x)) isValid = false;
                return new Pair(root.val, right.y);
            }
        }
        else {
            Pair left = helper(root.left);
            if (root.right == null) {
                if (!(root.val > left.y)) isValid = false;
                return new Pair(left.x, root.val);
            }
            else {
                Pair right = helper(root.right);
                if (!(root.val > left.y && root.val < right.x)) isValid = false;
                return new Pair(left.x, right.y);
            }
        }
    }
}

// Time complexity is O(n), where n is the number of nodes in the tree.
// Theorem: if the in-order traversal of a tree returns a sorted array, then the tree is a valid BST
// Proof is based on induction on the tree/sub-tree structures.
// Base case: The tree has 1 node.
// Inductive case:
// - Since the current node's left sub-tree returns a sorted array, we only need to check if the current node is larger than the last value in left tree's in-order traversal
// - Similarly, we only need to check if the current node is smaller than the first value in the right tree's in-order traversal
// - If the above checkes are both valid, then we have proven our theorem, because both left and right sub-trees are valid BST (according to inductive assumption), and we also have that "The left subtree of a node contains only nodes with keys less than the node's key. The right subtree of a node contains only nodes with keys greater than the node's key".

// Runtime: 1 ms, faster than 49.05% of Java online submissions for Validate Binary Search Tree.
// Memory Usage: 39.3 MB, less than 80.47% of Java online submissions for Validate Binary Search Tree.
