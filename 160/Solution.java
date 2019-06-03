/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode a = headA;
        while (a != null) {
            ListNode b = headB;
            while (b != null) {
                if (a == b) {
                    ListNode oldA = a;
                    ListNode oldB = b;
                    while (a == b && a != null && b != null) {
                        a = a.next;
                        b = b.next;
                    }
                    if (a == null && b == null) return oldA;
                    a = oldA;
                    b = oldB;
                }
                b = b.next;
            }
            a = a.next;
        }
        return null;
    }
}

// Runtime: 656 ms, faster than 5.01% of Java online submissions for Intersection of Two Linked Lists.
// Memory Usage: 48.4 MB, less than 5.04% of Java online submissions for Intersection of Two Linked Lists.

