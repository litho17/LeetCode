class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length==0) return false;
        int m = matrix[0].length;
        int n = matrix.length;
        int row = n-1;
        int col = m-1;
        while (row>=0 || col>=0) {
            if (row<0) {
                int[] nums = new int[n];
                for (int i=0; i<n; i++) {
                    nums[i] = matrix[i][col];
                }
                return binSearch(nums, 0, n-1, target);
            }
            if (col<0) {
                return binSearch(matrix[row], 0, m-1, target);
            }
            
            boolean res = binSearch(matrix[row], 0, m-1, target);
            if (res) return true;
            int[] nums = new int[n];
            for (int i=0; i<n; i++) {
                nums[i] = matrix[i][col];
            }
            res = binSearch(nums, 0, n-1, target);
            if (res) return true;
            row--;
            col--;
        }
        return false;
    }
    
    boolean binSearch(int[] nums, int start, int end, int tgt) {
        if (start>end || start<0 | end>=nums.length) return false;
        if (nums[start] == tgt) return true;
        if (nums[end] == tgt) return true;
        if (nums[start] > tgt) return false;
        if (nums[end] < tgt) return false;
        int mid = (start+end)/2;
        if (nums[mid] == tgt) return true;
        else if (nums[mid] > tgt) return binSearch(nums, start+1, mid-1, tgt);
        else return binSearch(nums, mid+1, end-1, tgt);
    }
}

// Runtime: 15 ms, faster than 5.71% of Java online submissions for Search a 2D Matrix II.
// Memory Usage: 44.8 MB, less than 94.34% of Java online submissions for Search a 2D Matrix II.

// Time complexity: Let M be max(m, n) and N be min(m, n), then time complexity is (log(m)+log(n))*N+log(M-N)
