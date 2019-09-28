class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        List<String> words = new LinkedList<>();
        for (int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == ' ') continue;
            sb.append(ch);
            int j;
            for (j=i+1; j<s.length(); j++) {
                char ch_ = s.charAt(j);
                if (ch_ == ' ') break;
                sb.append(ch_);
            }
            words.add(sb.toString());
            sb = new StringBuilder();
            i=j-1;
        }
        sb = new StringBuilder();
        for (int i=words.size()-1; i>=0; i--) {
            String word = words.get(i);
            if (i==words.size()-1) sb.append(word);
            else {
                sb.append(' ');
                sb.append(word);
            }
        }
        return sb.toString();
    }
}

// Runtime: 5 ms, faster than 58.40% of Java online submissions for Reverse Words in a String.
// Memory Usage: 38.5 MB, less than 53.76% of Java online submissions for Reverse Words in a String.
