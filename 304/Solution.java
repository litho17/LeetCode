class NumMatrix {
    int[][][] sums;
    int row;
    int col;
    public NumMatrix(int[][] matrix) {
        // assert(matrix.length>0);
        row = matrix.length;
        col = row>0 ? matrix[0].length : -1;
        if (row > 0) {
            sums = new int[matrix.length][col][col];
            for (int i=0; i<matrix.length; i++) {
                for (int j=0; j<matrix[i].length; j++) {
                    int tmp = 0;
                    for (int k=j; k<matrix[i].length; k++) {
                        tmp += matrix[i][k];
                        // tmp=∑(matrix[i][j],...,matrix[i][k])
                        sums[i][j][k] = tmp;
                    }
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (col>0 && row1>=0 && col1>=0 && row2<row && col2<col) {
            int ret = 0;
            for (int i=row1; i<=row2; i++) {
                ret += sums[i][col1][col2];
            }
            return ret;
        } else return 0;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */

// Runtime: 84 ms, faster than 11.05% of Java online submissions for Range Sum Query 2D - Immutable.
// Memory Usage: 73.2 MB, less than 5.07% of Java online submissions for Range Sum Query 2D - Immutable.

// Initially, I declared sums's type to be List<Map<Pair, Integer>>, where Pair is defined as <Integer, Integer>. However, this is too slow because of invoking library methods.
// Therefore I changed sums's type into int[][][].
// A faster and more space-efficient way is to do it with Dynamic Programming. Check this: https://www.cnblogs.com/grandyang/p/4958789.html
