class Solution {
    public List<String> generateParenthesis(int n) {
        if (n == 0) return new ArrayList<String>();
        Set<String> set = new HashSet<String>();
        set.add("()");
        int size = 1;
        for (int i = 2; i <= n; i++) {
            // Invariant: set contains the solution for n=i-1
            Set<String> newSet = new HashSet<String>();
            for (String s: set) {
                assert(s.length() > 1);
                // newSet.add("()"+s);
                for (int j = 0; j < s.length(); j++) {
                    newSet.add(s.substring(0, j) + "()" + s.substring(j));
                }
            }
            set = newSet;
            // Invariant: set contains the solution for n=i
        }
        return new ArrayList<String>(set);
    }
}

// Your runtime beats 5.98 % of java submissions.
