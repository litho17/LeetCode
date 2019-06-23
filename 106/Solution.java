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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length==0 || postorder.length==0) return null;
        return helper(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }
    
    // Return null iff. construction fails
    TreeNode helper(int[] inorder, int[] postorder, int s1, int e1, int s2, int e2) {
        assert(s1>=0 && e1<inorder.length && s2>=0 && e2<postorder.length && e1-s1==e2-s2);
        assert(s1<=e1 && s2<=e2);
        int mid = postorder[e2];
        TreeNode root = new TreeNode(mid);
        boolean success = false;
        if (s1==e1)  success = true; // Left/Right subtree is empty
        for (int i=s1; i<=e1; i++) { // Assume there might be duplicates in inorder or postorder
            if (inorder[i]==mid) {
                boolean leftEmpty = s1>i-1;
                boolean rightEmpty = i+1>e1;
                // If inorder[s1, i-1] is a permutation of postorder[s2, s2-s1+i-1]
                TreeNode left = leftEmpty ? null : helper(inorder, postorder, s1, i-1, s2, s2-s1+i-1);
                // If inorder[i+1, e1] is a permutation of postorder[s2-s1+i, e2-1]
                TreeNode right = rightEmpty ? null : helper(inorder, postorder, i+1, e1, s2-s1+i, e2-1);
                // System.out.println(leftEmpty+" "+rightEmpty+" "+left+" "+right);
                if ((left!=null || leftEmpty) && (right!=null || rightEmpty)) {
                    root.left = left;
                    root.right = right;
                    success = true;
                    break;
                }
            }
        }
        return success ? root : null;
    }
}

// Runtime: 15 ms, faster than 10.42% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
// Memory Usage: 42.9 MB, less than 8.13% of Java online submissions for Construct Binary Tree from Inorder and Postorder Traversal.
