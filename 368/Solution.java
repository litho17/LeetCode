class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int len = nums.length;
        if (len==0) return new LinkedList<>();
        Arrays.sort(nums);
        ArrayList<List<Integer>> res = new ArrayList(len);
        for (int i=0; i<len; i++) {
            res.add(new LinkedList<Integer>());
        }
        for (int i=len-1; i>=0; i--) {
            List<Integer> subset = new LinkedList<>();
            subset.add(nums[i]);
            List<Integer> max = new LinkedList<>();
            for (int j=i+1; j<len; j++) {
                if (nums[j]%nums[i]==0 && res.get(j).size()>max.size()) max = res.get(j);
            }
            subset.addAll(max);
            res.set(i, subset);
        }
        List<Integer> max = new LinkedList<>();
        for (int i=0; i<len; i++) {
            if (res.get(i).size()>max.size()) max = res.get(i);
        }
        return max;
    }
}

// Runtime: 18 ms, faster than 34.24% of Java online submissions for Largest Divisible Subset.
// Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Largest Divisible Subset.
