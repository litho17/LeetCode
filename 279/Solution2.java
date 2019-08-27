class Solution {
    public int numSquares(int n) {
        int r = (int)Math.sqrt(n);
        int[][] dp = new int[n+1][r+1];
        helper(n, r, dp);
        int min = n;
        for (int i=1; i<=r; i++) {
            if (dp[n][i]!=0 && dp[n][i]<min) min = dp[n][i];
        }
        return min;
    }
    
    // The largest square number we can use to decompose n is m^2
    int helper(int n, int m, int[][] dp) {
        // System.out.println(n+" "+m);
        int oldM=m;
        while (m*m>n) m--;
        assert (m>=1);
        if (n==0) return 0;
        if (dp[n][m]!=0) return dp[n][m];
        int min = n;
        for (int i=2; i<=m; i++) {
            int k = n/(i*i);
            int rem = n%(i*i);
            if (rem>0) {
                int res = helper(rem, i-1, dp);
                // System.out.println(k+" "+rem+" "+(i-1)+" "+dp[rem][i-1]);
                if (res!=0 && k+res<min) min = k+res;
            } else {
                if (k<min) min = k;
            }
        }
        dp[n][m] = min;
        return min;
    }
}

// Runtime: 28 ms, faster than 46.05% of Java online submissions for Perfect Squares.
// Memory Usage: 48.4 MB, less than 12.50% of Java online submissions for Perfect Squares.

