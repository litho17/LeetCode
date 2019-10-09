class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        int product = 1;
        for (int i=0; i<len; i++) {
            product *= nums[i];
            ret[i] = product;
        }
        product = 1;
        for (int i=len-1; i>=0; i--) {
            ret[i] = i==0 ? product : ret[i-1]*product;
            product *= nums[i];
        }
        return ret;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
// Memory Usage: 43.3 MB, less than 43.31% of Java online submissions for Product of Array Except Self.

// Now this is funny. Using constant space only beats 43% of Java submissions?
