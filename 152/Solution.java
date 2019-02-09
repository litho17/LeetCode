class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        int[] dpMax = new int[len]; // max product starting from i
        int[] dpMin = new int[len]; // min product starting from i
        
        dpMax[len-1] = nums[len-1];
        dpMin[len-1] = nums[len-1];
        for (int i = len-2; i >= 0; i--) {
            int v1 = nums[i]*dpMax[i+1];
            int v2 = nums[i]*dpMin[i+1];
            int v3 = nums[i];
            if (v1>=v2) {
                if (v2>=v3) {
                    dpMax[i] = v1;
                    dpMin[i] = v3;
                } else { // v1>=v2, v2<v3
                    dpMin[i] = v2;
                    if (v1>=v3) {
                        dpMax[i] = v1;
                    } else {
                        dpMax[i] = v3;
                    }
                }
            } else { // v1<v2
                if (v2<=v3) {
                    dpMax[i] = v3;
                    dpMin[i] = v1;
                } else { // v1<v2, v2>v3
                    dpMax[i] = v2;
                    if (v1>=v3) {
                        dpMin[i] = v3;
                    } else {
                        dpMin[i] = v1;
                    }
                }
            }
        }
        
        int max = dpMax[len-1];
        for (int i = len-2; i >= 0; i--) {
            if (dpMax[i] > max) max = dpMax[i];
        }
        return max;
    }
}

// Runtime: 1 ms, faster than 99.53% of Java online submissions for Maximum Product Subarray.
// Memory Usage: 22 MB, less than 60.32% of Java online submissions for Maximum Product Subarray.
