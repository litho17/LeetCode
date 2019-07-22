class Solution {
    public int integerReplacement(int n) {
        return helper((long)n, new HashMap<Long, Integer>());
    }
    
    int helper(Long n, Map<Long, Integer> map) {
        assert (n>0);
        if (n==1) return 0;
        if (n==2) return 1;
        if (n==3||n==4) return 2;
        if (n%2==0) return helper(n/2, map)+1;
        else {
            Integer r1 = map.get(n-1);
            if (r1==null && n-1>0) r1 = helper(n-1, map);
            Integer r2 = map.get(n+1);
            if (r2==null) r2 = helper(n+1, map);
            int r = r1<r2 ? r1 : r2;
            map.put(n, r+1);
            return r+1;
        }
    }
}

// Runtime: 38 ms, faster than 5.23% of Java online submissions for Integer Replacement.
// Memory Usage: 41.9 MB, less than 5.15% of Java online submissions for Integer Replacement.
