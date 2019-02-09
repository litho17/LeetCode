class WordDictionary {
    
    class Node {
        boolean isEnd;
        Node[] next;
        
        public Node() {
            next = new Node[26];
        }
    }

    Node root;
    /** Initialize your data structure here. */
    public WordDictionary() {
       root  = new Node();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        Node tmp = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            // Test if character c exists in the dict
            if (tmp.next[c-'a'] == null)
                tmp.next[c-'a'] = new Node();
            if (i == word.length()-1) tmp.next[c-'a'].isEnd = true;
            tmp = tmp.next[c-'a']; // Prepare for the next iteration
        }
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return search(word.toCharArray());
    }
    
    boolean search(char[] word) {
        // for (int i = 0; i < word.length; i++)
            // System.out.print(word[i]);
        // System.out.println();
        Node tmp = root;
        for (int i = 0; i < word.length; i++) {
            if (word[i] == '.') {
                for (int j = 0; j < 26; j++) {
                    char[] newWord = new char[word.length];
                    for (int k = 0; k < word.length; k++)
                        newWord[k] = word[k];
                    newWord[i] = (char)('a'+j);
                    boolean exist = search(newWord);
                    if (exist) return true;
                }
                return false;
            } else {
                char c = word[i];
                if (tmp.next[c-'a'] == null)  return false;
                else tmp = tmp.next[c-'a'];
            }
        }
        return tmp.isEnd;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */

// Runtime: 125 ms, faster than 50.00% of Java online submissions for Add and Search Word - Data structure design.
// Memory Usage: 49.7 MB, less than 47.56% of Java online submissions for Add and Search Word - Data structure design.
