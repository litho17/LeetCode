class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        if (len==0) return -1;
        int[] dp = new int[len];
        List<Integer> lstRow = triangle.get(len-1);
        for (int i=0; i<len; i++) {
            dp[i] = lstRow.get(i);
        }
        for (int i=len-2; i>=0; i--) {
            assert (dp.length==i+2);
            
            // lstRow = triangle.get(i+1);
            List<Integer> row = triangle.get(i);
            int[] newDP = new int[i+1];
            for (int j=0; j<=i; j++) {
                int min = dp[j]<=dp[j+1] ? dp[j] : dp[j+1];
                newDP[j] = min+row.get(j);
            }
            dp = newDP;
        }
        return dp[0];
    }
}

// Runtime: 1 ms, faster than 99.77% of Java online submissions for Triangle.
// Memory Usage: 36.2 MB, less than 95.92% of Java online submissions for Triangle.
