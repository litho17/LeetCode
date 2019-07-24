/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    class Pair {
        ListNode h, t;
        Pair (ListNode h, ListNode t) {
            this.h = h;
            this.t = t;
        }
    }
    
    public ListNode sortList(ListNode head) {
        if (head==null) return null;
        return helper(head).h;
    }
    
	// Quicksort
    Pair helper(ListNode head) {
        assert(head!=null);
        ListNode tmp = head.next;
        ListNode lh = null;
        ListNode lt = null;
        ListNode rh = null;
        ListNode rt = null;
        while (tmp!=null) {
            if (tmp.val<=head.val) {
                if (lh==null) {
                    assert(lt==null);
                    lh = tmp;
                    lt = tmp;
                } else {
                    assert (lh!=null);
                    lt.next = tmp;
                    lt = tmp;
                }
            } else {
                if (rh==null) {
                    assert(rt==null);
                    rh = tmp;
                    rt = tmp;
                } else {
                    assert (rh!=null);
                    rt.next = tmp;
                    rt = tmp;
                }
            }
            tmp = tmp.next;
        }
        // Clean up next field
        if (lt!=null) lt.next = null;
        if (rt!=null) rt.next = null;
        ListNode thisHead = null;
        ListNode thisTail = null;
        if (lh==null) {
            if (rh==null) {
                thisHead = head;
                thisTail = head;
            } else { // right list: null
                Pair newR = helper(rh);
                head.next = newR.h;
                thisHead = head;
                thisTail = newR.t;
            }
        } else { // left list: non-null
            Pair newL = helper(lh);
            thisHead = newL.h;
            if (rh==null) { // right list: null
                newL.t.next = head;
                thisTail = head;
                head.next = null;
            } else {
                Pair newR = helper(rh);
                thisTail = newR.t;
                newL.t.next = head;
                head.next = newR.h;
            }
        }
        assert(thisHead!=null && thisTail!=null && thisTail.next==null);
        return new Pair(thisHead, thisTail);
    }
}

// Runtime: 557 ms, faster than 5.48% of Java online submissions for Sort List.
// Memory Usage: 39.2 MB, less than 99.35% of Java online submissions for Sort List.
