class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len==0) return 0;
        for (int i=0; i<=len; i++) {
            boolean isValid = true;
            for (int j=len-1; j>len-1-i; j--) { // i papers that each has ≥i citations
                if (citations[j]<i) {
                    isValid = false;
                    break;
                }
            }
            for (int j=len-1-i; j>=0; j--) { // len-i papers that each has ≤i citations
                if (citations[j]>i) {
                    isValid = false;
                    break;
                }
            }
            if (isValid) return i;
        }
        assert(false);
        return -1;
    }
}

// Runtime: 4 ms, faster than 7.43% of Java online submissions for H-Index II.
// Memory Usage: 45.1 MB, less than 61.24% of Java online submissions for H-Index II.
