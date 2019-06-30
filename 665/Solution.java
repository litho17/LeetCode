
class Solution {
    public boolean checkPossibility(int[] nums) {
        if (nums.length<=1) return true;
        boolean existsA = nums[1]>=nums[0];
        if (existsA) {
            int i=1;
            for (; i<nums.length; i++) {
                boolean xMustBeI = nums[i]<nums[i-1];
                // A: [0, i-1]
                // X: i
                // B: [i+1, nums.length-1], which may not exist
                // Check if [i+1, nums.length-1] is a non-decreasing array
                int j=i+2;
                for (; j<nums.length; j++) {
                    if (nums[j]<nums[j-1]) break;
                }
                if (j>=nums.length) { // B is valid or B does not exist
                    // System.out.println(i+" "+j);
                    if (xMustBeI) {
                        if (i<nums.length-1) return nums[i+1]>=nums[i-1]; // B is valid
                        else return true; // B does not exist
                    } else {
                        if (i<nums.length-1 && nums[i+1]>=nums[i-1]) return true;
                    }
                } else { // B is not valid
                    assert (nums[j]<nums[j-1]);
                    if (xMustBeI) return false;
                }
            }
            // A is valid
            return true;
        } else {
            // Check if [1, nums.length-1] is a non-decreasing array
            for (int i=2; i<nums.length; i++) {
                if (nums[i]<nums[i-1]) return false;
            }
            return true;
        }
    }
}

// Runtime: 4 ms, faster than 7.50% of Java online submissions for Non-decreasing Array.
// Memory Usage: 40.1 MB, less than 95.36% of Java online submissions for Non-decreasing Array.

// There are 4 cases: (where X stands for an element in the input array)
// 1. A, X, B where (1) A and B are valid (2) A has at least 1 element (3) B has at least 1 element
// 2. A, X where (1) A is valid (2) A has at least 1 element
// 3. X, B where (1) B is valid (2) B has at least 1 element
// 4. A // where (1) A is valid (2) A has at least 1 element 
