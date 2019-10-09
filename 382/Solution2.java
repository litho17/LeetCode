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
    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    public Solution(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        int val = head.val;
        ListNode tmp = head.next;
        int count = 2;
        while (tmp != null) {
            int r = getRandom(1, count);
            if (r <= 1) val = tmp.val;
            tmp = tmp.next;
            count++;
        }
        return val;
    }
    
    int getRandom(int min, int max) {
        int range = max-min+1;
        return (int)(Math.random() * range) + min;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */

// https://en.wikipedia.org/wiki/Reservoir_sampling
