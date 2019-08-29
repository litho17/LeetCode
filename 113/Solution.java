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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root==null) return res;
        res = helper(root, sum);
        for (List<Integer> list: res) {
            Collections.reverse(list);
        }
        return res;
    }
    
    // Lists are all reversed
    List<List<Integer>> helper(TreeNode root, int sum) {
        assert (root!=null);
        List<List<Integer>> res = new LinkedList<>();
        if (root.left==null && root.right==null) {
            if (sum==root.val) {
                List<Integer> l = new LinkedList<>();
                l.add(root.val);
                res.add(l);
            }
            return res;
        }
        if (root.left!=null) {
            List<List<Integer>> left = helper(root.left, sum-root.val);
            for (List<Integer> list: left) {
                List<Integer> l = new LinkedList<>();
                l.addAll(list);
                l.add(root.val);
                res.add(l);
            }
        }
        if (root.right!=null) {
            List<List<Integer>> right = helper(root.right, sum-root.val);
            for (List<Integer> list: right) {
                List<Integer> l = new LinkedList<>();
                l.addAll(list);
                l.add(root.val);
                res.add(l);
            }
        }
        return res;
    }
}

// Runtime: 10 ms, faster than 5.81% of Java online submissions for Path Sum II.
// Memory Usage: 39 MB, less than 95.45% of Java online submissions for Path Sum II.
