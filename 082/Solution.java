/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode tmp = head; // A node which we don't know if to keep or not
        ListNode newHead = null; // The valid head node
        ListNode last = null; // The last kept node
        while (tmp != null) {
            if (tmp.next!=null && tmp.next.val==tmp.val) {
                // Find the last node that has a same value as tmp.val
                ListNode tmp2 = tmp.next;
                while (tmp2!=null && tmp2.val==tmp.val) {
                    tmp2 = tmp2.next;
                }
                // Let last.next be the next possibly valid node
                if (tmp2==null) {
                    if (last!=null) last.next = null;
                    break;
                } else {
                    if (last!=null) last.next = tmp2;
                    tmp = tmp2;
                }
            } else {
                last = tmp;
                if (newHead==null) newHead = tmp;
                tmp = tmp.next;
            }
        }
        return newHead;
    }
}

// Runtime: 1 ms, faster than 81.12% of Java online submissions for Remove Duplicates from Sorted List II.
// Memory Usage: 37.2 MB, less than 98.43% of Java online submissions for Remove Duplicates from Sorted List II.
