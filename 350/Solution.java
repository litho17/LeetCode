class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int num: nums1) {
            Integer count = map1.get(num);
            if (count == null) map1.put(num, 1);
            else map1.put(num, count+1);
        }
        for (int num: nums2) {
            Integer count = map2.get(num);
            if (count == null) map2.put(num, 1);
            else map2.put(num, count+1);
        }
        List<Integer> ret = new LinkedList<>();
        for (Integer num: map1.keySet()) {
            Integer count2 = map2.get(num);
            if (count2 != null) {
                Integer count1 = map1.get(num);
                int minCount = count1<=count2 ? count1 : count2;
                for (int i=0; i<minCount; i++) {
                    ret.add(num);
                }
            }
        }
        int[] ary = new int[ret.size()];
        for (int i=0; i<ret.size(); i++) {
            ary[i] = ret.get(i);
        }
        return ary;
    }
    
    // For each num in nums1, do a binary search in nums2 (where nums2 can be stored into a
    // Red-Black tree s.t. each time an element is matched, it can be removed from the tree)
}

// Runtime: 4 ms, faster than 23.11% of Java online submissions for Intersection of Two Arrays II.
// Memory Usage: 36.2 MB, less than 85.48% of Java online submissions for Intersection of Two Arrays II.

