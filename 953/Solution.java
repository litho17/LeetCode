class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i=0; i<order.length(); i++) {
            map.put(order.charAt(i), i); // Smaller idx means "larger"
        }
        map.put('~', -1);
        for (int i=0; i<words.length-1; i++) {
            String word1 = words[i];
            String word2 = words[i+1];
            int maxLen = word1.length()>=word2.length() ? word1.length() : word2.length();
            for (int j=0; j<maxLen; j++) {
                char ch1 = j>=word1.length() ? '~' : word1.charAt(j);
                char ch2 = j>=word2.length() ? '~' : word2.charAt(j);
                Integer idx1 = map.get(ch1);
                Integer idx2 = map.get(ch2);
                if (idx1<idx2) break;
                else if (idx1>idx2) return false;
            }
        }
        return true;
    }
}

// Runtime: 1 ms, faster than 42.66% of Java online submissions for Verifying an Alien Dictionary.
// Memory Usage: 36.1 MB, less than 100.00% of Java online submissions for Verifying an Alien Dictionary.
