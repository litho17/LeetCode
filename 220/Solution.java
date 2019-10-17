class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k<=0) return false;
        for (int i=0; i<k && i<nums.length; i++) { // Any two numbers in [0, k]
            for (int j=i+1; j<=k && j<nums.length; j++) {
                boolean res = helper(nums[i], nums[j], t);
                if (res) return true;
            }
        }
        for (int j=k+1; j<nums.length; j++) {
            for (int i=j-k; i<j; i++) { // (i,j),...,(j-1,j)
                boolean res = helper(nums[i], nums[j], t);
                if (res) return true;
            }
        }
        return false;
    }
    
    boolean helper(int a, int b, int t) {
        long diff = (long)a - (long) b;
        diff = diff<0 ? -diff : diff;
        if (diff<=(long)t) return true;
        return false;
    }
}

// Runtime: 375 ms, faster than 15.74% of Java online submissions for Contains Duplicate III.
// Memory Usage: 37.9 MB, less than 59.09% of Java online submissions for Contains Duplicate III.
