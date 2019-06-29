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
    public int pathSum(TreeNode root, int sum) {
        if (root==null) return 0;
        int ret = 0;
        
        int r1 = pathSum(root.left, sum);
        ret += r1;
        int r2 = helper1(root.left, sum-root.val); // Since root is included and a path cannot be discontinous, root.left must be included as well
        ret += r2;
        
        int r3  = pathSum(root.right, sum);
        ret += r3;
        int r4 = helper1(root.right, sum-root.val);
        ret += r4;
        
        if (root.val==sum) ret++;
        return ret;
    }
    
    int helper1(TreeNode root, int sum) { // Must include root
        if (root==null) return 0;
        int ret=0;
        if (root.val==sum) ret++;
        int r1 = helper1(root.left, sum-root.val); // Since root is included and a path cannot be discontinous, root.left must be included as well
        int r2 = helper1(root.right, sum-root.val);
        return ret+r1+r2;
    }
}

// Runtime: 11 ms, faster than 45.99% of Java online submissions for Path Sum III.
// Memory Usage: 41.3 MB, less than 48.19% of Java online submissions for Path Sum III.
