/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m<1||n<m) return null;
        int count = 1;
        ListNode lst = null;  // lst will be the m-1-th node or null
        ListNode nxt = null;  // nxt will be the n+1-th node or null
        ListNode tmp = head;  // tmp will be the m-th node
        ListNode tmp2 = null; // tmp2 will be the n-th node
        while (tmp!=null) {
            // tmp is the count-th node
            if (count==m) {
                tmp2 = tmp;
                ListNode tmp3 = null; // The node that should be tmp2.next
                while (count<n) {
                    // tmp2 is the count-th node
                    ListNode tmp4 = tmp2.next;
                    tmp2.next = tmp3;
                    tmp3 = tmp2;
                    // System.out.println(tmp2.val+" "+count);
                    // if (tmp2.next!=null) System.out.print(" "+tmp2.next.val);
                    tmp2 = tmp4;
                    count++;
                }
                assert (tmp2!=null);
                nxt = tmp2.next;
                tmp2.next = tmp3;
                break;
            }
            lst = tmp;
            tmp = tmp.next;
            count++;
        }
        // System.out.println(tmp.val+" "+tmp2.val);
        // System.out.println(lst.val+" "+nxt.val);
        // From m to n is reversed
        tmp.next = nxt;
        if (lst==null) {
            return tmp2;
        } else {
            lst.next = tmp2;
            return head;
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List II.
// Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Reverse Linked List II.

