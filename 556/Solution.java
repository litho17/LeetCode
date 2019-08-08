class Solution {
    public int nextGreaterElement(int n) {
        ArrayList<Integer> digits = new ArrayList<>();
        while (n>0) {
            digits.add(n%10);
            n /= 10;
        }
        // Find max i s.t. [0, i] is non-decreasing
        int i;
        for (i=0; i<digits.size(); i++) {
            if (i>0 && digits.get(i)<digits.get(i-1)) break;
        }
        if (i==digits.size()) return -1;
        i--;
        int nxt = digits.get(i+1);
        int cur = digits.get(i);
        if (nxt==cur) return -1;
        else {
            assert (nxt<cur);
            // Find j s.t. digits[j]>nxt
            int j;
            for (j=0; j<=i; j++) {
                if (digits.get(j)>nxt) break;
            }
            if (j>cur) j = i;
            // System.out.println(i+" "+j);
            // swap digits[i+1] and digits[j]
            digits.set(i+1, digits.get(j));
            digits.set(j, nxt);
            /*for (Integer d: digits) {
                System.out.print(d);
            }
            System.out.println();*/
            // sort [0, i]: Put nxt to an appropriate position s.t. [0, i] is non-decreasing
            int tmpJ = j;
            while (tmpJ-1>=0&&digits.get(tmpJ-1)>nxt) {
                    int tmp = digits.get(tmpJ-1);
                    digits.set(tmpJ-1, nxt);
                    digits.set(tmpJ, tmp);
                    tmpJ--;
                }
            tmpJ = j;
            while (tmpJ+1<=i&&digits.get(tmpJ+1)<nxt) {
                    int tmp = digits.get(tmpJ+1);
                    digits.set(tmpJ+1, nxt);
                    digits.set(tmpJ, tmp);
                    tmpJ++;
                }
            /*for (Integer d: digits) {
                System.out.print(d);
            }
            System.out.println();*/
            // Reverse [0, i] s.t. [0, i] is non-increasing
            for (int k=0; k<=i/2; k++) {
                int tmp = digits.get(i-k);
                digits.set(i-k, digits.get(k));
                digits.set(k, tmp);
            }
            
            long ret = 0;
            long ten = 1;
            for (Integer d: digits) {
                ret += ten*d;
                if (ret>Integer.MAX_VALUE) return -1;
                ten *= 10;
            }
            return (int)ret;
        }
    }
}

// Runtime: 1 ms, faster than 26.10% of Java online submissions for Next Greater Element III.
// Memory Usage: 32.8 MB, less than 10.00% of Java online submissions for Next Greater Element III.

