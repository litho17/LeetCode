class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int product = 1;
        for (int i=0; i<len; i++) {
            product *= nums[i];
            left[i] = product;
        }
        product = 1;
        for (int i=len-1; i>=0; i--) {
            product *= nums[i];
            right[i] = product;
        }
        int[] ret = new int[len];
        for (int i=0; i<len; i++) {
            int l = i-1>=0 ? left[i-1] : 1;
            int r = i+1<len ? right[i+1] : 1;
            ret[i] = l*r;
        }
        return ret;
    }
}

// Runtime: 1 ms, faster than 100.00% of Java online submissions for Product of Array Except Self.
// Memory Usage: 41.2 MB, less than 100.00% of Java online submissions for Product of Array Except Self.

