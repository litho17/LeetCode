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

/*
    How did I come up with the algorithm?
    1. Pre-condition before invoking function helper(root) in Problem 116: root.next is known
    2. Shall we visit root.left or root.right first? root.right, because establishing pre-conditions for root.left depends on establishing pre-conditions for root.right
    3. To establish the pre-condition defined in Step 1 for root.right before invoking helper(root.right), we need a stronger pre-condition: root.next* is known, i.e. root.next, root.next.next, root.next.next, ... are all known
    4. To establish the stronger pre-condition defined in Step 3 for root.right, we need to ...
*/

class Solution {
    public Node connect(Node root) {
        helper(root);
        return root;
    }
    
    // Algorithm
    // 1. Establish pre-condition for root.right
    // 2. Visit root.right
    // 3. Establish pre-condition for root.left
    // 4. Visit root.left
    void helper(Node root) {
        if (root == null) return;
        Node next = root.next; // The node on the same level as root
        Node target = null; // The node that root.right.next should be
        while (next != null) {
            if (next.left != null) {
                target = next.left;
                break;
            } else if (next.right != null) {
                target = next.right;
                break;
            } else {
                next = next.next;
            }
        }
        if (root.right != null) {
            root.right.next = target;
            helper(root.right);
        }
        if (root.left != null) {
            if (root.right == null) {
                root.left.next = target;
            } else {
                root.left.next = root.right;
            }
            helper(root.left);
        }
    }
}

// Runtime: 1 ms, faster than 86.86% of Java online submissions for Populating Next Right Pointers in Each Node II.
// Memory Usage: 50.8 MB, less than 94.94% of Java online submissions for Populating Next Right Pointers in Each Node II.
