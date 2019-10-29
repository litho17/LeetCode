class StreamChecker {
    Node root;
    StringBuilder sb;

    class Node {
        Node[] nodes;
        boolean isWord; // A node is the end of a word iff. (1) it is not null (2) isWord is true
        // char val;
        public Node() {
            nodes = new Node[26];
        }
    }

    void insert(String word) {
        Node tmp = root;
        for (int i=word.length()-1; i>=0; i--) {
            // Invariant: tmp != null
            // Ready to match the next char
            char ch = word.charAt(i);
            if (tmp.nodes[ch-'a'] == null) {
                tmp.nodes[ch-'a'] = new Node();
            }
            tmp = tmp.nodes[ch-'a'];
        }
        tmp.isWord = true;
    }

    boolean exists(String word) {
        Node tmp = root;
        for (int i=word.length()-1; i>=0; i--) {
            char ch = word.charAt(i);
            if (tmp.nodes[ch-'a'] == null) return false;
            else {
                if (tmp.nodes[ch-'a'].isWord) return true;
                else tmp = tmp.nodes[ch-'a'];
            }
        }
        return tmp.isWord;
    }

    public StreamChecker(String[] words) {
        this.root = new Node();
        for (String word: words) {
            insert(word);
        }
        sb = new StringBuilder();
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        return exists(sb.toString());
    }
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words);
 * boolean param_1 = obj.query(letter);
 */

// Runtime: 493 ms, faster than 25.33% of Java online submissions for Stream of Characters.
// Memory Usage: 92.1 MB, less than 60.00% of Java online submissions for Stream of Characters.
