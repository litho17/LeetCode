class Solution {
    public int kthGrammar(int N, int K) {
        return helper(N, K);
    }
    
    int helper(int N, int K) {
        if (N==1 && K==1) return 0;
        
        int res = helper(N-1, (K+1)/2);
        if (K%2 == 0) { // The right
            if (res == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else { // The left
            if (res == 0) {
                return 0;
            }
            else {
                return 1;
            }
        }
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for K-th Symbol in Grammar.
// Memory Usage: 33.1 MB, less than 16.67% of Java online submissions for K-th Symbol in Grammar.
