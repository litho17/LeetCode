class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                helper(matrix, i, j, dp);
            }
        }
        int max = 0;
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[0].length; j++) {
                if (dp[i][j] > max) max = dp[i][j];
            }
        }
        return max;
    }
    
    void helper(int[][] matrix, int i, int j, int[][] dp) {
        if (dp[i][j]>0) return;
        int up = 0;
        if (i-1>=0 && matrix[i-1][j]>matrix[i][j]) {
            if (dp[i-1][j]==0) helper(matrix, i-1, j, dp);
            up = dp[i-1][j];
        }
        int down = 0;
        if (i+1<matrix.length && matrix[i+1][j]>matrix[i][j]) {
            if (dp[i+1][j]==0) helper(matrix, i+1, j, dp);
            down = dp[i+1][j];
        }
        int left = 0;
        if (j-1>=0 && matrix[i][j-1]>matrix[i][j]) {
            if (dp[i][j-1]==0) helper(matrix, i, j-1, dp);
            left = dp[i][j-1];
        }
        int right = 0;
        if (j+1<matrix[0].length && matrix[i][j+1]>matrix[i][j]) {
            if (dp[i][j+1]==0) helper(matrix, i, j+1, dp);
            right = dp[i][j+1];
        }
        int max = up;
        if (down>max) max = down;
        if (left>max) max = left;
        if (right>max) max = right;
        assert(max>=0);
        dp[i][j] = max+1;
    }
}

// Runtime: 15 ms, faster than 28.44% of Java online submissions for Longest Increasing Path in a Matrix.
// Memory Usage: 40 MB, less than 97.96% of Java online submissions for Longest Increasing Path in a Matrix.
