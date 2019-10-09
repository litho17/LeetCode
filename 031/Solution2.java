class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length<=1) return;
        int idx = -1;
        for (int i=nums.length-2; i>=0; i--) {
            if (nums[i]<nums[i+1]) {
                idx = i;
                break;
            }
        }
        
        if (idx == -1) {
            reverse(nums, 0, nums.length-1);
        }
        else {
            reverse(nums, idx+1, nums.length-1);
            for (int j=idx+1; j<nums.length; j++) {
                if (nums[j]>nums[idx]) {
                    int tmp = nums[j];
                    nums[j] = nums[idx];
                    nums[idx] = tmp;
                    break;
                }
            }
        }
    }
    
    void reverse(int[] nums, int start, int end) {
        int mid = (start+end)/2;
        for (int i=start; i<=mid; i++) {
            int j = end+start-i;
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}

// Runtime: 1 ms, faster than 89.12% of Java online submissions for Next Permutation.
// Memory Usage: 42.8 MB, less than 20.00% of Java online submissions for Next Permutation.
