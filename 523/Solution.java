class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length<=1) return false;
        if (k==0) { // nums[i]>=0
            // If we have a continuous sub-array with all 0s
            int count = -1;
            for (int i=0; i<nums.length; i++) {
                if (nums[i]==0) {
                    if (count==-1) count = 1;
                    else count++;
                } else {
                    if (count>=2) return true;
                    count = -1;
                }
            }
            return count>=2;
        }
        if (k<0) k = -k;
        List<Integer> mods = new LinkedList<>();
        int lstMod = nums[0]%k;
        mods.add(lstMod);
        for (int i=1; i<nums.length; i++) {
            lstMod = (lstMod+nums[i])%k;
            // Assume that we are comparing the sums of two sub-arrays, one of which has a length of at least 3 and the other has a length of at least 1
            // i.e. 2=n-(n-2) where n≥1
            if (mods.contains(lstMod) && i-mods.indexOf(lstMod)>1) return true;
            mods.add(lstMod);
        }
        // The sum of all numbers
        return lstMod==0;
    }
}

// Runtime: 50 ms, faster than 5.00% of Java online submissions for Continuous Subarray Sum.
// Memory Usage: 40.2 MB, less than 89.86% of Java online submissions for Continuous Subarray Sum.
