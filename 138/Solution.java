/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        Node headp = new Node(head.val, null, null);
        Node last = headp;
        Node tmp = head.next;
        List<Node> list = new LinkedList<>();
        list.add(headp);
        Map<Node, Integer> map = new HashMap<>();
        map.put(head, 0);
        int idx = 1;
        while (tmp!=null) {
            map.put(tmp, idx);
            Node n = new Node(tmp.val, null, null);
            list.add(n);
            last.next = n;
            last = n;
            tmp = tmp.next;
            idx++;
        }
        tmp = head;
        idx = 0;
        while (tmp!=null) {
            if (tmp.random!=null) list.get(idx).random = list.get(map.get(tmp.random));
            tmp = tmp.next;
            idx++;
        }
        return headp;
    }
}

// Runtime: 2 ms, faster than 72.90% of Java online submissions for Copy List with Random Pointer.
// Memory Usage: 34.2 MB, less than 95.73% of Java online submissions for Copy List with Random Pointer.

