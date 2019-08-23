class Trie {
    
    class Node {
        char ch;
        Node[] next;
        boolean isWord;
        public Node(char ch) {
            this.ch = ch;
            next = new Node[26];
        }
    }
    
    Node root;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node('1');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] ary = word.toCharArray();
        Node tmp = root;
        for (int i=0; i<ary.length; i++) {
            char ch = ary[i];
            if (tmp.next[ch-'a']==null) {
                for (int j=i; j<ary.length; j++) {
                    char ch_ = ary[j];
                    Node n = new Node(ch_);
                    tmp.next[ch_-'a'] = n;
                    tmp = n;
                }
                break;
            } else tmp = tmp.next[ch-'a'];
        }
        tmp.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] ary = word.toCharArray();
        Node tmp = root;
        for (int i=0; i<ary.length; i++) {
            char ch = ary[i];
            if (tmp.next[ch-'a']==null) return false;
            else tmp = tmp.next[ch-'a'];
        }
        return tmp.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] ary = prefix.toCharArray();
        Node tmp = root;
        for (int i=0; i<ary.length; i++) {
            char ch = ary[i];
            if (tmp.next[ch-'a']==null) return false;
            else tmp = tmp.next[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

// Runtime: 75 ms, faster than 74.60% of Java online submissions for Implement Trie (Prefix Tree).
// Memory Usage: 49.2 MB, less than 100.00% of Java online submissions for Implement Trie (Prefix Tree).

