class Solution {
    public int expressiveWords(String S, String[] words) {
        int count = 0;
        for (String word: words) {
            int s1 = 0;
            int e1 = s1;
            int s2 = 0;
            int e2 = s2;
            boolean isStretchy = true;
            while (e1<word.length() && e2<S.length()) {
                // s1==e1 && s2==e2
                while (e1+1<word.length() && word.charAt(e1+1)==word.charAt(s1)) {
                    e1++;
                }
                while (e2+1<S.length() && S.charAt(e2+1)==S.charAt(s2)) {
                    e2++;
                }
                // [s1, e1] is a group of chars in word
                // [s2, e2] is a group of chars in S
                if (word.charAt(s1) == S.charAt(s2)) {
                    int len1 = e1-s1+1;
                    int len2 = e2-s2+1;
                    if (len1==len2 || (len2>=3&&len1<len2)) {
                        // Maintain loop invariant
                        s1 = e1 + 1;
                        e1 = s1;
                        s2 = e2 + 1;
                        e2 = s2;
                    }
                    else {
                        isStretchy = false;
                        break;
                    }
                }
                else {
                    isStretchy = false;
                    break;
                }
            }
            if (isStretchy && (e1==word.length()&&e2==S.length())) count++;
        }
        return count;
    }
}

// Runtime: 7 ms, faster than 15.57% of Java online submissions for Expressive Words.
// Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Expressive Words.
