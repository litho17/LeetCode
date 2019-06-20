/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        int len = 0;
        ListNode n = head;
        while (n != null) {
            n = n.next;
            len++;
        }
        int[] ary = new int[len];
        n = head;
        for (int i=0; i<len; i++) {
            ary[i] = n.val;
            n = n.next;
        }
        for (int i=0; i<=len/2; i++) {
            if (ary[i]!=ary[len-1-i]) return false;
        }
        return true;
    }
}

// Runtime: 1 ms, faster than 98.17% of Java online submissions for Palindrome Linked List.
// Memory Usage: 40.8 MB, less than 98.63% of Java online submissions for Palindrome Linked List.
