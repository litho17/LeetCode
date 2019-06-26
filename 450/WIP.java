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
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode newRoot = root;
        
        // Find the node to remove
        TreeNode remove = root;
        TreeNode removeParent = null; // The node whose left/right child is remove
        while (remove!=null && remove.val!=key) {
            removeParent = remove;
            if (remove.val<key) remove = remove.right;
            else remove = remove.left;
        }
        if (remove==null) return root;
        assert (remove!=null && remove.val==key);
        
        // Find a leaf node, i.e. it must have no left/right child and it must not be the same as remove
        TreeNode leaf = remove;
        TreeNode leafParent = removeParent; // The node whose left/right child is leaf
        while (leaf!=null && (leaf.left!=null || leaf.right!=null)) {
            leafParent = leaf;
            if (leaf.left!=null) leaf = leaf.left; // leaf.right==null
            else leaf = leaf.right; // leaf.right!=null
        }
        assert (leaf!=null && leaf.left==null && leaf.right==null);
        if (leaf == remove) {
            if (leafParent != null) {
                if (leafParent.left==leaf) leafParent.left = null;
                else leafParent.right = null;
                return root;
            } else {
                return null;
            }
        }
        
        // Delete leaf, i.e. no node in the tree rooted at newRoot can point to it
        assert (leafParent!=null);
        if (leafParent.left==leaf) leafParent.left = null;
        else leafParent.right = null;
        
        // Delete remove, i.e. no node in the tree rooted at newRoot can point to it
        if (removeParent != null) {
            if (removeParent.left==remove) removeParent.left = leaf;
            else removeParent.right = leaf;
        } else {
            newRoot = leaf;
        }
        
        // Replace remove with leaf
        leaf.left = remove.left;
        leaf.right = remove.right;
        
        // Re-sort the tree
        TreeNode tmp = leaf;
        TreeNode tmpParent = leafParent;
        while (tmp!=null) {
            boolean updated = false;
            TreeNode left = tmp.left;
            TreeNode right = tmp.right;
            if (left!=null) {
                if (tmp.val<left.val) { // Swap tmp and tmp.left
                    if (tmpParent.left == tmp) tmpParent.left = left;
                    else tmpParent.right = left;
                    tmp.left = left.left;
                    TreeNode t = left.right;
                    left.right = tmp.right;
                    tmp.right = t;
                    left.left = tmp;
                    tmpParent = left;
                    updated = true;
                }
            }
            if (right!=null) {
                if (tmp.val>right.val) {
                    if (tmpParent.left == tmp) tmpParent.left = right;
                    else tmpParent.right = right;
                    tmp.right = right.right;
                    TreeNode t = right.left;
                    right.left = tmp.left;
                    tmp.left =  t;
                    right.right = tmp;
                    tmpParent = right;
                    updated = true;
                }
            }
            if (!updated) break;
        }
        return newRoot;
    }
}

// I used the algorithm for deleting a node in Min Heap here...
