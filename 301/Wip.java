class Solution {
    class Candidate {
        private Set<String> set;
        
        public Candidate() {
            set = new HashSet<String>();
            // set.add("");
        }
        
        public void add(java.util.Collection<String> c) {
            // set = new HashSet<String>();
            for (String s: c) {
                set.add(s);
            }
        }
        
        public void add(String prefix, java.util.Collection<String> c) {
            // set = new HashSet<String>();
            for (String s: c) {
                set.add(prefix+s);
            }
        }
        
        public void add(String s) {
            set.add(s);
        }
        
        public String toString() {
            return set.toString();
        }
        
        public Candidate copy() {
            Candidate ret = new Candidate();
            for (String s: set) {
                ret.add(s);
            }
            return ret;
        }
    }
    
    Candidate[] dp;
    
    public List<String> removeInvalidParentheses(String s) {
        dp = new Candidate[s.length()];
        int len = s.length();
        if (len == 0) return new ArrayList<String>();
        dp[len-1] = new Candidate();
        if (Character.isLetter(s.charAt(0))) dp[len-1].add(s);
        if (len == 1) return new ArrayList<>(dp[0].set);
        dp[len-2] = new Candidate();
        char a = s.charAt(0);
        char b = s.charAt(1);
        if (a == '(' && b == ')') dp[len-2].add("()");
        if (Character.isLetter(a) && Character.isLetter(b)) dp[len-2].add(""+a+b);
        
        // Invariant: forall i. dp[i] is null
        // Invariant: dp[i] stores a set of all solution for string s.substring(i) that removes least # of parentheses
        helper(s);
        return new ArrayList<>(dp[0].set);
    }
    
    void helper(String s) {
        char[] a = s.toCharArray();
        int len = a.length;
        for (int i = len-3; i >= 0; i--) {
            dp[i] = new Candidate();
            if (a[i] == '(') {
                // Choose the first right parenthesis to keep, which matches a[i]
                for (int j = i+1; j < len; j++) {
                    if (a[j] == ')') {
                        if (j+1 > len-1) {
                            dp[i].add("()");
                        } else {
                            dp[i].add("()", dp[j+1].set);
                            //
                            System.out.println(s.substring(i) + "    " + dp[i] + "    " + dp[j+1]);
                        }
                    }
                }
            } else if (a[i] == ')' || Character.isLetter(a[i])) {
                for (int j = i+1; j < len; j++) {
                    if (a[j] == '(') {
                        dp[i] = dp[j].copy();
                        break;
                    }
                }
            } else {
                assert (false);
            }
            // System.out.println(s.substring(i) + "    " + dp[i]);
        }
    }
}
