class Solution {
    public String convertToTitle(int n) {
		// Find A_1A_2...A_m such that n = 26^0*(A_m-'A'+1) + 26^1*(A_{m-1}-'A'+1) + ...
        if (n<1) assert(false);
        StringBuilder sb = new StringBuilder();
        while (n>26) {
            int d = n%26;
            // d+'A'-1 ∈ ['A'-1, 'Y']
            if (d==0) {
                sb.append('Z');
                n -= 26;
            } else {
                sb.append((char)(d+'A'-1));
                n -= d;
            }
            n = n/26;
        }
        if (n==0) sb.append('Z');
        else sb.append((char)(n+'A'-1));
        return sb.reverse().toString();
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Excel Sheet Column Title.
// Memory Usage: 33.8 MB, less than 100.00% of Java online submissions for Excel Sheet Column Title.
