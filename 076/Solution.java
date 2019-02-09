class Solution {
    
    class Count {
        int[] c;
        
        public Count() {
            c = new int[128];
        }
        
        public Count(char[] a) {
            c = new int[128];
            for (char ch: a) {
                c[ch]++;
            }
        }
        
        public void add(char ch) {
            c[ch]++;
        }
        
        public void remove(char ch) {
            c[ch]--;
        }
        
        public boolean greaterThan(Count other) {
            for (int i = 0; i < 128; i++) {
                if (this.c[i] < other.c[i]) return false;
            }
            return true;
        }
        
        public String toString() {
            String s = "";
            for (int i = 0; i < 128; i++) {
                if (c[i] != 0) s = s + i + ": " + c[i] + ", ";
            }
            return s;
        }
    }
    
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) return "";
        
        char[] S = s.toCharArray();
        char[] T = t.toCharArray();
        Count countT = new Count(T);
        
        Count count = new Count();
        boolean findFirst = false;
        String ret = "";
        int lastIdx = S.length-1;
        for (int i = S.length-1; i>=0; i--) {
            count.add(S[i]);
            if (findFirst) { // Loop phase 2
                // Invariant: Each time before setting ret, make sure ret is as tight as possible
                // Try to move lastIdx as forward as possible
                while (true)  {
                    count.remove(S[lastIdx]);
                    if (count.greaterThan(countT)) lastIdx--;
                    else {
                        count.add(S[lastIdx]);
                        String tmp = s.substring(i, lastIdx+1);
                        if (tmp.length() < ret.length()) ret = tmp;
                        break;
                    }
                }
            } else { // Loop phase 1
                if (count.greaterThan(countT)) {
                    // Invariant: Each time before setting ret, make sure ret is as tight as possible
                    while (true)  {
                        count.remove(S[lastIdx]);
                        if (count.greaterThan(countT)) lastIdx--;
                        else {
                            count.add(S[lastIdx]);
                            ret = s.substring(i, lastIdx+1);
                            break;
                        }
                    }
                    findFirst = true;
                }
            }
        }
        
        return ret;
    }
}

// Runtime: 152 ms, faster than 4.61% of Java online submissions for Minimum Window Substring.
// Memory Usage: 31.9 MB, less than 4.71% of Java online submissions for Minimum Window Substring.

