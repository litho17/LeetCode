/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {}

    public Node(int _val,List<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
};
*/
class Solution {
    public Node cloneGraph(Node node) {
        if (node==null) return null;
        Map<Node, Node> map = new HashMap<>();
        Set<Node> visited = new HashSet<>();
        Stack<Node> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node oldN = stack.pop();
            if (visited.contains(oldN)) continue; // oldN might have been visited --- it might be added to the stack for multiple times
            visited.add(oldN);
            Node newN = findOrCreate(oldN, map);
            if (newN.neighbors==null) newN.neighbors = new LinkedList<Node>();
            for (Node neighbor: oldN.neighbors) {
                Node neighbor_ = findOrCreate(neighbor, map);
                assert (!newN.neighbors.contains(neighbor_));
                newN.neighbors.add(neighbor_);
                if (!visited.contains(neighbor)) stack.push(neighbor);
            }
        }
        return map.get(node);
    }
    
    Node findOrCreate(Node oldN, Map<Node, Node> map) {
        Node newN = map.get(oldN);
        if (newN==null) {
            newN = new Node();
            newN.val = oldN.val;
            map.put(oldN, newN);
        }
        return newN;
    }
}

// Runtime: 3 ms, faster than 7.08% of Java online submissions for Clone Graph.
// Memory Usage: 33.3 MB, less than 98.25% of Java online submissions for Clone Graph.
