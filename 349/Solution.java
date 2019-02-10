class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int len = nums1.length<nums2.length ? nums1.length : nums2.length; 
        int[] tmp = new int[len];
        int count = 0;
        int pointer1 = 0;
        // Invariant: pointer1 points to the starting index in nums1 for the next number in nums2 to compare against
        // Invariant: 0<=j<nums1.length
        for (int i = 0; i < nums2.length; i++) {
            if (i>0 && nums2[i]==nums2[i-1]) continue;
            for (int j = pointer1; j < nums1.length; j++) {
                if (nums1[j] < nums2[i]) {
                    ;
                } else if (nums1[j] == nums2[i]) {
                    // I am about to put nums1[j] into the final result
                    if (count==0 || (count>0&&tmp[count-1]!=nums1[j])) { // Not put repetitive elements into the result
                        tmp[count] = nums1[j];
                        count++;
                    }
                    pointer1 = j;
                    break;
                } else {
                    pointer1 = j-1>0 ? j-1: 0;
                    break;
                }
            }
        }
        
        int[] ret = new int[count];
        for (int i = 0; i < count; i++) {
            ret[i] = tmp[i];
        }
        return ret;
    }
}

// Runtime: 2 ms, faster than 98.75% of Java online submissions for Intersection of Two Arrays.
// Memory Usage: 26.6 MB, less than 25.94% of Java online submissions for Intersection of Two Arrays.
