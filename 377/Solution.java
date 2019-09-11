class Solution {
    public int combinationSum4(int[] nums, int target) {
        // if (nums.length==0) return 0;
        Arrays.sort(nums);
        Map<Integer, Integer> dp = new HashMap<>();
        return helper(nums, target, dp);
    }
    
    int helper(int[] nums, int tgt, Map<Integer, Integer> dp) {
        int ret = 0;
        
        // Use binary search to find tgt in nums
        int idx = binSearch(nums, tgt, 0, nums.length-1);
        if (idx != -1) ret++;
        
        for (int i=0; i<nums.length; i++) {
            int newTgt = tgt-nums[i];
            if (newTgt>0) {
                Integer res = dp.get(newTgt);
                if (res == null) res = helper(nums, newTgt, dp);
                ret += res;
            }
        }
        dp.put(tgt, ret);
        return ret;
    }
    
    int binSearch(int[] nums, int tgt, int start, int end) {
        int len = nums.length;
        if (len==0) return -1;
        if (start>end || start<0 || end>len-1) return -1;
        if (tgt<nums[start] || tgt>nums[end]) return -1;
        int mid = (start+end)/2;
        if (tgt<nums[mid]) return binSearch(nums, tgt, start, mid-1);
        else if (tgt==nums[mid]) return mid;
        else return binSearch(nums, tgt, mid+1, end);
    }
}

// Runtime: 2 ms, faster than 22.07% of Java online submissions for Combination Sum IV.
// Memory Usage: 36.6 MB, less than 12.90% of Java online submissions for Combination Sum IV.
