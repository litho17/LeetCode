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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Inductive proof: If two trees are the same in inorder traversal, then they are the same
        // This property also not holds for preorder or postorder traversal.
        List<Integer> lp = inorder(p);
        List<Integer> lq = inorder(q);
        if (lp.size() != lq.size()) return false;
        System.out.println(-685 == -685);
        System.out.println(lp);
        System.out.println(lq);
        for (int i = 0; i < lp.size(); i++) {
            // == between Integer, Long etc will check for reference equality
            // Reference: https://stackoverflow.com/questions/1514910/how-to-properly-compare-two-integers-in-java
            Integer a = lp.get(i);
            Integer b = lq.get(i);
            if (a == null && b != null) return false;
            if (a != null && b == null) return false;
            if (a == null && b == null) continue;
            if (a-b != 0) return false;
        }
        return true;
    }
    
    // Use null to keep track of information about tree structures
    // Add null only when one subtree is not null, i.e. the root node dooes not have left/right subtree
    List<Integer> inorder(TreeNode root) {
        List<Integer> ret = new LinkedList<Integer>();
        if (root != null) {
            ret.add(root.val);
            if (root.left == null) {
                if (root.right == null) {
                    ;
                } else {
                    ret.add(null);
                    ret.addAll(inorder(root.right));
                }
            } else {
                if (root.right == null) {
                    ret.addAll(inorder(root.left));
                    ret.add(null);
                } else {
                    ret.addAll(inorder(root.left));
                    ret.addAll(inorder(root.right));
                }
            }
        }
        return ret;
    }
}
