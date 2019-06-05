/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    class Pair {
        List<Node> rightmost;
        List<Node> leftmost;
        
        public Pair(List<Node> r, List<Node> l) {
            rightmost = r;
            leftmost = l;
        }
    }
    
    public Node connect(Node root) {
        if (root == null) return null;
        helper(root);
        return root;
    }
    
    Pair helper(Node root) {
        assert (root != null);
        root.next = null;
        List<Node> leftmost  = new LinkedList<Node>();
        List<Node> rightmost = new LinkedList<Node>();
        leftmost.add(root);
        rightmost.add(root);
        if (root.left != null) {
            if (root.right != null) {
                Pair l = helper(root.left);
                Pair r = helper(root.right);
                for (int i = 0; i < l.rightmost.size(); i++) {
                    Node right = l.rightmost.get(i);
                    Node left = r.leftmost.get(i);
                    right.next = left;
                }
                leftmost.addAll(l.leftmost);
                rightmost.addAll(r.rightmost);
            } else {
                assert (false);
            }
        } else {
            if (root.right != null) {
                assert (false);
            } else {
                ;
            }
        }
        return new Pair(rightmost, leftmost);
    }
    
    
}

// Runtime: 2 ms, faster than 39.35% of Java online submissions for Populating Next Right Pointers in Each Node.
// Memory Usage: 33.3 MB, less than 99.60% of Java online submissions for Populating Next Right Pointers in Each Node.
