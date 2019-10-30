class Solution {
    public String strWithout3a3b(int A, int B) {
        StringBuilder sb = new StringBuilder();
        char a = A>=B ? 'a' : 'b';
        char b = A>=B ? 'b' : 'a';
        int max = A>=B ? A : B;
        int min = A>=B ? B : A;
        if (max-min<=2) {
            for (int i=0; i<min; i++) {
                sb.append(a);
                sb.append(b);
            }
            for (int i=0; i<max-min; i++) {
                sb.append(a);
            }
        }
        else {
			// y is the # of a's at the end of the output string
            for (int y=0; y<=2; y++) {
                int x = max-min-y;
                if (x<=min) {
                    for (int i=0; i<x; i++) {
                        sb.append(a);
                        sb.append(a);
                        sb.append(b);
                    }
                    for (int i=0; i<min-x; i++) {
                        sb.append(a);
                        sb.append(b);
                    }
                    for (int i=0; i<y; i++) {
                        sb.append(a);
                    }
                    break;
                }
            }
        }
        return sb.toString();
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for String Without AAA or BBB.
// Memory Usage: 34 MB, less than 100.00% of Java online submissions for String Without AAA or BBB.
