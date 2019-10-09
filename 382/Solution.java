/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    
    ListNode head;
    List<Integer> vals;

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
        ListNode tmp = head;
        vals = new LinkedList<Integer>();
        while (tmp != null) {
            vals.add(tmp.val);
            tmp = tmp.next;
        }
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int min = 0;
        int max = vals.size()-1;
        int range = max-min+1;
        int r = (int)(Math.random() * range) + min;
        return vals.get(r);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

// Runtime: 55 ms, faster than 59.36% of Java online submissions for Linked List Random Node.
// Memory Usage: 41.8 MB, less than 13.33% of Java online submissions for Linked List Random Node.
