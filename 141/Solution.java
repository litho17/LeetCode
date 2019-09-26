/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode, Integer> map = new HashMap();
        ListNode tmp = head;
        int idx = 0;
        while (tmp != null) {
            if (map.get(tmp) != null) return true;
            map.put(tmp, idx);
            tmp = tmp.next;
            idx++;
        }
        return false;
    }
}

