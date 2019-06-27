class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int accuI = 0; // # of zeros in the result, starting from the right most digit
        while (n > m) {
            // Let the right most digit be 1st digit and the left most digit be 32nd digit.
            // Find i such that n-m≥2^i-1. Then we know that ∀i∈[1,i].i-th digit in the result is 0.
            int i=1;
            int tmp=2; // Loop invariant: tmp=2^i
            while (n-m<tmp-1) {
                i++;
                tmp*=2;
            }
            accuI += i;
            n = n>>i;
            m = m>>i;
        } // Exit the loop only when n==m
        return n<<accuI;
    }
}

// Runtime: 4 ms, faster than 100.00% of Java online submissions for Bitwise AND of Numbers Range.
// Memory Usage: 35.5 MB, less than 5.08% of Java online submissions for Bitwise AND of Numbers Range.
