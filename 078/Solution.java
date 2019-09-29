class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        // res.add(new LinkedList<Integer>());
        helper(new LinkedList<Integer>(), nums, 0, res);
        return res;
    }
    
    void helper(List<Integer> path, int[] nums, int idx, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(path);
            return;
        }
        
        List<Integer> newPath0 = new LinkedList<>();
        newPath0.addAll(path);
        newPath0.add(nums[idx]);
        List<Integer> newPath1 = new LinkedList<>();
        newPath1.addAll(path);
        
        helper(newPath0, nums, idx+1, res);
        helper(newPath1, nums, idx+1, res);
    }
}

// Runtime: 1 ms, faster than 41.71% of Java online submissions for Subsets.
// Memory Usage: 37.7 MB, less than 95.08% of Java online submissions for Subsets.

