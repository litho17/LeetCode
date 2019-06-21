class Solution {
    public int lengthOfLastWord(String s) {
        char[] ary = s.toCharArray();
        if (ary.length==0) return 0;
        else if (ary.length==1) {
            if(ary[0]==' ') return 0;
            else return 1;
        }
        char lastChar = ary[0]; // The last visited char
        int start = lastChar!=' ' ? 0 : -1;  // Start index of the current word
        int end = -1; // End index of the current word
        for (int i=1; i<ary.length; i++) { // This is implementing some Finite State Automata
            char c = ary[i];
            if (c != ' ') {
                if (lastChar==' ' || start==-1) start = i;
            } else {
                if (lastChar!=' ') end = i-1;
            }
            lastChar = c;
        }
        if (lastChar!=' ') end=ary.length-1; // Invariant: End must be set for the current word. E.g. "word   "
        if (start==-1||end==-1) return 0;
        else return end-start+1;
    }
}

// Runtime: 1 ms, faster than 54.78% of Java online submissions for Length of Last Word.
// Memory Usage: 35.6 MB, less than 99.97% of Java online submissions for Length of Last Word.
