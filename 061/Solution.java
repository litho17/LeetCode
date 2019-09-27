/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode tmp = head;
        ListNode tail = null;
        while (tmp != null) {
            if (tmp.next == null) {
                tail = tmp;
            }
            tmp = tmp.next;
            len++;
        }
        if (len == 0) return head;
        assert(tail != null);
        
        int idx = k % len;
        if (idx == 0) return head;
        
        // Find the (len+1-idx) node
        int count = 1;
        tmp = head;
        ListNode prev = null; // The (len-idx) node
        while ((len+1-idx) != count && tmp != null) {
            if (len-idx == count) {
                prev = tmp;
            }
            tmp = tmp.next;
            count++;
        }
        assert (len+1-idx == count);
        if (prev == null) return head;
        prev.next = null;
        
        tail.next = head;
        return tmp;
    }
}

// Runtime: 1 ms, faster than 23.61% of Java online submissions for Rotate List.
// Memory Usage: 37.8 MB, less than 79.31% of Java online submissions for Rotate List.
