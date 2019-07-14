/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = l1.val+l2.val;
        int carry = sum/10;
        ListNode head = new ListNode(sum%10);
        ListNode last = head;
        ListNode n1 = l1.next;
        ListNode n2 = l2.next;
        while (n1!=null || n2!=null) {
            if (n1!=null) {
                if (n2!=null) {
                    sum = n1.val+n2.val+carry;
                    ListNode n = new ListNode(sum%10);
                    carry = sum/10;
                    n1 = n1.next;
                    n2 = n2.next;
                    last.next = n;
                    last = n;
                } else {
                    sum = n1.val+carry;
                    ListNode n = new ListNode(sum%10);
                    carry = sum/10;
                    n1 = n1.next;
                    last.next = n;
                    last = n;
                }
            } else {
                if (n2!=null) {
                    sum = n2.val+carry;
                    ListNode n = new ListNode(sum%10);
                    carry = sum/10;
                    n2 = n2.next;
                    last.next = n;
                    last = n;
                } else {
                    assert(false);
                }
            }
        }
        if (carry!=0) {
            assert (carry==1);
            ListNode n = new ListNode(1);
            last.next = n;
        }
        return head;
    }
}

// Runtime: 2 ms, faster than 86.40% of Java online submissions for Add Two Numbers.
// Memory Usage: 43.8 MB, less than 86.76% of Java online submissions for Add Two Numbers.
