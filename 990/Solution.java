class Solution {
    class Node {
        char val;
        Node parent;
        public Node(char val) {
            this.val = val;
            this.parent = this;
        }
    }
    public boolean equationsPossible(String[] equations) {
        Node[] nodes = new Node[26];
        for (int i=0; i<26; i++) {
            nodes[i] = new Node((char)('a'+i));
        }
        for (String equation: equations) {
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            boolean isEqual = equation.charAt(1) == '=';
            Node p1 = find(nodes[ch1-'a']);
            Node p2 = find(nodes[ch2-'a']);
            if (isEqual) p1.parent = p2;
        }
        for (String equation: equations) {
            char ch1 = equation.charAt(0);
            char ch2 = equation.charAt(3);
            boolean isEqual = equation.charAt(1) == '=';
            Node p1 = find(nodes[ch1-'a']);
            Node p2 = find(nodes[ch2-'a']);
            if (!isEqual) {
                if (p1==p2) return false;
            }
        }
        return true;
    }
    
    Node find(Node n) {
        Node tmp = n;
        while (tmp.parent != tmp) {
            tmp = tmp.parent;
        }
        return tmp;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Satisfiability of Equality Equations.
// Memory Usage: 36 MB, less than 100.00% of Java online submissions for Satisfiability of Equality Equations.
