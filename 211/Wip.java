class WordDictionary {
    TrieNode root;
    
    class TrieNode {
        boolean isLastChar; // indicate if this node represents an intermediate or the last char
        TrieNode[] next;
        
        public TrieNode() {
            next = new TrieNode[26];
            isLastChar = false;
        }
    }

    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
        // Invariant: Each word is stored in a path from root node to null
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode tmp = root;
        char[] a = word.toCharArray();
        for (int i = 0; i < a.length; i++) {
            // Invariant: tmp.next is always initialized at this location
            if (tmp.next[a[i]-'a'] == null) { // If not yet initialized
                tmp.next[a[i]-'a'] = new TrieNode();
            }
            tmp = tmp.next[a[i]-'a'];
            // Invariant: tmp points to the node of a[i]
            if (i == a.length-1) tmp.isLastChar = true;
        }
        // assert(search(word));
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        char[] a = word.toCharArray();
        return search(a);
    }
    
    private boolean search(char[] word) {
        TrieNode tmp = root;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    word[i] = (char)('a'+j); // This should only modify the local copy of word
                    if (search(word)) return true;
                }
                System.out.println(word);
                return false;
            } else {
                if (tmp.next[word[i]-'a'] == null) { // i-th char of word does not exist in the dict
                    System.out.println(word);
                    return false;
                }
                tmp = tmp.next[word[i]-'a']; // Otherwise, i-th char is matched
            }
        }
        // When "bac" is in dict and "b" is not, search("b") should return false
        if (!tmp.isLastChar) System.out.println(word);;
        return tmp.isLastChar;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
