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
    public List<TreeNode> generateTrees(int n) {
        if (n<=0) return new LinkedList<TreeNode>();
        return helper(1, n);
    }
    
    List<TreeNode> helper(int start, int end) {
        List<TreeNode> ret = new LinkedList<>();
        if (end<start) {
            return ret;
        } else if (end==start) {
            ret.add(new TreeNode(start));
            return ret;
        }
        //System.out.println(start+" "+end);
        for (int i=start; i<=end; i++) {
            List<TreeNode> lefts  = helper(start, i-1);
            List<TreeNode> rights = helper(i+1, end);
            //System.out.println(start+" "+i+" "+end+" "+lefts.size()+" "+rights.size());
            if (lefts.size()==0) {
                if (rights.size()==0) {
                    ;
                } else {
                    for (TreeNode right: rights) {
                        TreeNode m = new TreeNode(i);
                        m.right = right;
                        ret.add(m);
                    }
                }
            } else {
                if (rights.size()==0) {
                    for (TreeNode left: lefts) {
                        TreeNode m = new TreeNode(i);
                        m.left = left;
                        ret.add(m);
                    }
                } else {
                    for (TreeNode left: lefts) {
                        for (TreeNode right: rights) {
                            TreeNode m = new TreeNode(i);
                            m.left = left;
                            m.right = right;
                            ret.add(m);
                        }
                    }
                }
            }
        }
        return ret;
    }
}

// Runtime: 2 ms, faster than 71.11% of Java online submissions for Unique Binary Search Trees II.
// Memory Usage: 37 MB, less than 100.00% of Java online submissions for Unique Binary Search Trees II.
