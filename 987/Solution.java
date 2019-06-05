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
    class Idx implements Comparable<Idx> {
        int v;   // vertical distance to root node
        int val; // val stored in the node
        
        public Idx(int v, int val) {
            this.v = v;
            this.val = val;
        }
        
        public int compareTo(Idx other){
            if (this.v < other.v) { // other.v is closer to top node
                return 1;
            } else if (this.v == other.v) {
                if (this.val < other.val) return -1;
                else if (this.val == other.val) return 0;
                else return 1;
            } else {
                return -1;
            }
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Idx>> map = new HashMap<>();
        helper(root, 0, 0, map);
        
        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys); // Sort outer lists
        List<List<Integer>> ret = new LinkedList<>();
        for (Integer key: keys) {
            List<Idx> l = map.get(key);
            assert (l != null);
            Collections.sort(l); // Sort inner lists
            List<Integer> l2 = new LinkedList<>();
            for (Idx idx: l) {
                l2.add(idx.val);
            }
            ret.add(l2);
        }
        return ret;
    }
    
    // Preorder traversal: Any traversal order is fine
    void helper(TreeNode root, int hdist, int vdist, Map<Integer, List<Idx>> map) {
        if (root == null) return;
        List<Idx> l = map.get(hdist);
        if (l == null) {
            l = new LinkedList<Idx>();
            map.put(hdist, l);
        }
        l.add(new Idx(vdist, root.val));
        helper(root.left, hdist-1, vdist-1, map);
        helper(root.right, hdist+1, vdist-1, map);
    }
}

// Runtime: 3 ms, faster than 80.68% of Java online submissions for Vertical Order Traversal of a Binary Tree.
// Memory Usage: 36.2 MB, less than 99.92% of Java online submissions for Vertical Order Traversal of a Binary Tree.
