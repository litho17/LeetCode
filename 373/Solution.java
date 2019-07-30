class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new LinkedList<>();
        if (k<=0 || nums1.length==0 || nums2.length==0) return res;
        // lstIdx[j] denotes the last used idx in nums2 s.t. (i, lstIdx[j]) is already used
        int[] lstIdx = new int[nums1.length];
        for (int i=0; i<nums1.length; i++) {
            lstIdx[i] = -1;
        }
        for (int i=0; i<k; i++) {
            int nextIdx = -1;
            int min = Integer.MAX_VALUE;
            for (int j=0; j<nums1.length; j++) {
                if (lstIdx[j]+1>=nums2.length) continue;
                int sum = nums1[j]+nums2[lstIdx[j]+1];
                if (sum<min) {
                    nextIdx = j;
                    min = sum;
                }
            }
            if (nextIdx==-1) break;
            List<Integer> p = new LinkedList<>();
            p.add(nums1[nextIdx]);
            p.add(nums2[++lstIdx[nextIdx]]);
            res.add(p);
        }
        return res;
    }
}

// Runtime: 14 ms, faster than 75.28% of Java online submissions for Find K Pairs with Smallest Sums.
// Memory Usage: 37.3 MB, less than 89.21% of Java online submissions for Find K Pairs with Smallest Sums.

