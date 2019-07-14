
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
        ListNode one = head;
        ListNode two = head;
        while (one!=null && one.next!=null && two!=null && two.next!=null && two.next.next!=null) {
            one = one.next;
            two = two.next.next;
        }
        if (one==two) return;
        ListNode mid = one.next;
        assert (mid!=null);
        one.next = null; // [head, one]
        // Reverse: [mid, n]
        ListNode last = mid;
        ListNode tmp = mid.next;
        mid.next = null;
        while (tmp!=null) {
            ListNode t = tmp.next;
            tmp.next = last;
            last = tmp;
            tmp = t;
        }
        // System.out.println(last.val+" "+mid.val+" "+head.val+" "+one.val);
        // Interwine: [n, mid] and [head, one], where last==n
        ListNode tmp1 = head;
        ListNode tmp2 = last;
        //assert (last!=null);
        while (tmp1!=one) {
            ListNode t1 = tmp1.next;
            ListNode t2 = tmp2.next;
            tmp1.next = tmp2;
            tmp2.next = t1;
            tmp1 = t1;
            tmp2 = t2;
        }
        if (tmp2!=null) one.next = mid;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Reorder List.
// Memory Usage: 39.7 MB, less than 90.38% of Java online submissions for Reorder List.
