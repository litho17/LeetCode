class Solution {
    public String longestPalindrome(String s) {
        if (s.length()<=1) return s;
        int max = 1;
        int l = 0;
        int r = 0;
        char[] ary = s.toCharArray();
        for (int i=0; i<ary.length; i++) { // i: mid point
            for (int j=0; i-j>=0; j++) { // j: half len
                boolean isValid1 = i+j<ary.length ? true : false; // Odd length
                for (int k=i; 2*i-k<=i+j && isValid1; k--) {
                    if (ary[k]!=ary[2*i-k]) {
                        isValid1 = false;
                    }
                }
                boolean isValid2 = i+j+1<ary.length ? true : false; // Even length
                for (int k=i; 2*i+1-k<=i+j+1 && isValid2; k--) {
                    if (ary[k]!=ary[2*i+1-k]) {
                        isValid2 = false;
                    }
                }
                //System.out.println(isValid1+" "+s.substring(i-j,i+j+1)+" "+isValid2+" "+s.substring(i-j,i+j+2));
                if (isValid2) {
                    int len2 = 2*j+2;
                    if (len2>max) {
                        l = i-j;
                        r = i+j+1;
                        max = len2;
                        // System.out.println(s.substring(l,r+1));
                    }
                } else {
                    if (isValid1) {
                        int len1 = 2*j+1;
                        if (len1>max) {
                            l = i-j;
                            r = i+j;
                            max = len1;
                            // System.out.println(s.substring(l,r+1));
                        }
                    } else break;
                }
            }
        }
        assert(l>=0 && r<ary.length);
        return s.substring(l,r+1); // [l, r+1)
    }
}

// Runtime: 467 ms, faster than 7.50% of Java online submissions for Longest Palindromic Substring.
// Memory Usage: 36.2 MB, less than 99.97% of Java online submissions for Longest Palindromic Substring.
