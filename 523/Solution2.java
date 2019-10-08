class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        // To store sums of array [1,1],...,[1,end-1],...,[end-1,end-1], because of [i+1,j] where i>=0 and j<=end-1
        Map<Integer, List<Integer>> map = new HashMap<>();
        int sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            int key = k==0 ? sum : sum%k;
            if (key==0 && i>=1) return true; // Sums of array [0,0],...[0,end-1]
            List<Integer> list = map.get(key);
            if (list == null) {
                list = new LinkedList<Integer>();
                map.put(key, list);
            }
            list.add(i);
        }
        
        for (List<Integer> list: map.values()) {
            if (list.size() == 1) continue;
            else if (list.size() == 2) {
                if (list.get(1)-list.get(0)>=2) return true;
            }
            else return true;
        }
        return false;
    }
}

// Runtime: 12 ms, faster than 27.08% of Java online submissions for Continuous Subarray Sum.
// Memory Usage: 39.1 MB, less than 100.00% of Java online submissions for Continuous Subarray Sum.
