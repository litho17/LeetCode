class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); // (k, v): Last indexes v where nums[v]==k
        for (int i=0; i<nums.length; i++) {
            Integer idx = map.get(nums[i]);
            if (idx == null) {
                map.put(nums[i], i);
            } else {
                if (i-idx<=k) return true;
                else map.put(nums[i], i);
            }
        }
        return false;
    }
}

// Runtime: 9 ms, faster than 49.44% of Java online submissions for Contains Duplicate II.
// Memory Usage: 41.8 MB, less than 77.94% of Java online submissions for Contains Duplicate II.
