class Solution {
    public int compareVersion(String v1, String v2) {
        List<String> nums1 = new ArrayList<String>(Arrays.asList(v1.split("\\.")));
        List<String> nums2 = new ArrayList<String>(Arrays.asList(v2.split("\\.")));
        int diff = (nums1.size()-nums2.size()>=0) ? nums1.size()-nums2.size() : nums2.size()-nums1.size();
        // System.out.println(nums1.size()+" "+nums2.size());
        for (int i=0; i<diff; i++) {
            if (nums1.size()>nums2.size()) nums2.add("0");
            else nums1.add("0");
        }
        assert (nums1.size()==nums2.size());
        for (int i=0; i<nums1.size(); i++) {
            int n1 = Integer.parseInt(nums1.get(i));
            int n2 = Integer.parseInt(nums2.get(i));
            if (n1>n2) return 1;
            else if (n1<n2) return -1;
        }
        return 0;
    }
}

// Runtime: 2 ms, faster than 16.58% of Java online submissions for Compare Version Numbers.
// Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Compare Version Numbers.
