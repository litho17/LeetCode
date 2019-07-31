class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m==0) return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i=m-1; i>=0; i--) {
            for (int j=n-1; j>=0; j--) {
                if (matrix[i][j]=='0') dp[i][j] = 0;
                else {
                    int cdd1 = -1;
                    if (i+1<m) {
                        for (int a=dp[i+1][j]; a>=1; a--) {
                            cdd1 = a+1;
                            int row = i+a;
                            int col = j+a;
                            for (int k=i+1; k<=row; k++) {
                                if (k>=m || col>=n || matrix[k][col]=='0') {
                                    cdd1 = -1;
                                    break;
                                }
                            }
                            for (int k=j+1; k<=col; k++) {
                                if (k>=n || matrix[i][k]=='0') {
                                    cdd1 = -1;
                                    break;
                                }
                            }
                            if (cdd1!=-1) break;
                        }
                    }
                    int cdd2 = -1;
                    if (j+1<n) {
                        for (int a=dp[i][j+1]; a>=1; a--) {
                            cdd2 = a+1;
                            int row = i+a;
                            int col = j+a;
                            for (int k=j+1; k<=col; k++) {
                                if (k>=n || row>=m || matrix[row][k]=='0') {
                                    cdd2 = -1;
                                    break;
                                }
                            }
                            for (int k=i+1; k<=row; k++) {
                                if (k>=m || matrix[k][j]=='0') {
                                    cdd2 = -1;
                                    break;
                                }
                            }
                            if (cdd2!=-1) break;
                        }
                    }
                    if (cdd1==-1) {
                        if (cdd2==-1) {
                            dp[i][j] = 1;
                            if (1>max) max = 1;
                        } else {
                            dp[i][j] = cdd2;
                            if (cdd2>max) max = cdd2;
                        }
                    } else {
                        if (cdd2==-1) {
                            dp[i][j] = cdd1;
                            if (cdd1>max) max = cdd1;
                        } else {
                            int max_ = cdd1>=cdd2 ? cdd1 : cdd2;
                            dp[i][j] = max_;
                            if (max_>max) max = max_;
                        }
                    }
                    // System.out.println(i+" "+j+" "+dp[i][j]);
                }
            }
        }
        return max*max;
    }
}

// Runtime: 9 ms, faster than 9.15% of Java online submissions for Maximal Square.
// Memory Usage: 43.2 MB, less than 81.62% of Java online submissions for Maximal Square.
