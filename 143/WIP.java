/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head==null) return;
        ListNode n1 = head; // i-th node
        ListNode n2 = null; // (i+1)-th node
        // ListNode n3 = null; // m-th node which starts as the last node and should not be the same as n2
        ListNode lastN3 = null;
        while (n1!=null) {
            n2 = n1.next;
            // Invariant: ∀nodes in [n2, n3], its next field has never been updated
            if (n2==null || n2==lastN3) break;
            // Find n3
            ListNode n3 = n2;
            while (n3!=null && n3.next!=lastN3) {
                n3 = n3.next;
            }
            assert(n3!=null && n3.next==lastN3);
            if (n3 != n2) {
                lastN3 = n3;
                n1.next = n3;
                n3.next = n2;
                n1 = n2;
                // Ready to find the next n2 and n3
            } else break;
        }
    }
}
