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
    
    public int countNodes(TreeNode root) {
        if (root==null) return 0;
        else if (root.left==null) return 1;
        return helper(root);
    }
    
    // # of nodes
    int helper(TreeNode root) {
        assert (root!=null);
        if (root.left!=null) {
            if (root.right!=null) {
                int lh = height(root.left);
                int rh = height(root.right);
                if (lh==rh) {
                    // root.left is complete
                    return (int)Math.pow(2,lh)+helper(root.right);
                } else if (lh>rh) {
                    // root.right is complete
                    return (int)Math.pow(2,rh)+helper(root.left);
                }
            } else {
                return 2;
            }
        } else {
            if (root.right!=null) {
                ;
            } else {
                return 1;
            }
        }
        assert(false);
        return -1;
    }
    
    // # of nodes from root to its left most node
    int height(TreeNode root) {
        if (root==null) return 0;
        int h = 1;
        TreeNode tmp = root.left;
        while (tmp!=null) {
            tmp = tmp.left;
            h++;
        }
        return h;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
// Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Count Complete Tree Nodes.
