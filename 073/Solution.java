
class Solution {
    public void setZeroes(int[][] matrix) {
        boolean[] row = new boolean[matrix.length]; // If there exists a zero in row i
        if (matrix.length==0) return;
        boolean[] col = new boolean[matrix[0].length]; // If there exists a zero in col j
        for (int i=0; i<matrix.length; i++) {
            boolean existsZero = false;
            for (int j=0; j<matrix[i].length; j++) {
                if (matrix[i][j]==0) {
                    existsZero = true;
                    break;
                }
            }
            row[i] = existsZero;
        }
        for (int j=0; j<matrix[0].length; j++) {
            boolean existsZero = false;
            for (int i=0; i<matrix.length; i++) {
                if (matrix[i][j]==0) {
                    existsZero = true;
                    break;
                }
            }
            col[j] = existsZero;
        }
        for (int i=0; i<matrix.length; i++) {
            for (int j=0; j<matrix[i].length; j++) {
                if (row[i] || col[j]) matrix[i][j] = 0;
            }
        }
    }
}

// Runtime: 1 ms, faster than 98.78% of Java online submissions for Set Matrix Zeroes.
// Memory Usage: 49.3 MB, less than 15.74% of Java online submissions for Set Matrix Zeroes.
