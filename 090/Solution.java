class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ret = new LinkedList<>();
        ret.add(new LinkedList<>()); // Empty set
        int len = nums.length;
        if (len==0) return ret;
        Arrays.sort(nums);
        List<Integer> one = new LinkedList<>(); // All distinct numbers
        for (int i=0; i<len; i++) {
            if (!one.contains(nums[i])) one.add(nums[i]);
        }
        for (int i=0; i<one.size(); i++) { // Subsets with size 1
            List<Integer> l = new LinkedList<Integer>();
            l.add(one.get(i));
            ret.add(l);
        }
        int count = one.size();
        for (int n=2; n<=len; n++) {
            int start = ret.size()-count;
            int end = ret.size()-1;
            count = 0; // The number of subsets with size n-1
            for (int i=start; i<=end; i++) {
                List<Integer> l = ret.get(i); // A subset with size n-1
                int lstNum = l.get(l.size()-1);
                int c = 0; // # of appearance of lstNum in the subset
                for (int j=l.size()-1; j>=0; j--) {
                    if (l.get(j)==lstNum) c++;
                }
                for (int j=0; j<len; j++) {
                    if (nums[j]==lstNum) { // Find the next appearance of lstNum in nums
                        // System.out.println(lstNum+" "+c+" "+(c+j));
                        for (int k=c+j; k<len; k++) {
                            if (k==c+j || nums[k]!=nums[k-1]) {
                                List<Integer> lp = new LinkedList<>(l); // A subset with size n
                                lp.add(nums[k]);
                                ret.add(lp);
                                count++;
                            }
                        }
                        break;
                    }
                }
            }
        }
        return ret;
    }
}

// Runtime: 2 ms, faster than 19.48% of Java online submissions for Subsets II.
// Memory Usage: 37.3 MB, less than 98.53% of Java online submissions for Subsets II.
