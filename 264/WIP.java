class Solution {
    public int nthUglyNumber(int n) {
        if (n<=1) return 1;
        Set<Integer> set = new HashSet<>();
        set.add(1);
        int count=1;
        int i=2;
        // Invariant: If x<i and x is ugly number, then x∈set
        while (count!=n) {
            // i is a ugly number <=> (i%2==0 and i/2 must belong to set) or (i%3==0 and i/3 must belong to set) or (i%5==0 and i/5 must belong to set)
            if (i%2==0 && set.contains(i/2)) {
                count++;
                set.add(i);
            } else if (i%3==0 && set.contains(i/3)) {
                count++;
                set.add(i);
            } else if (i%5==0 && set.contains(i/5)) {
                count++;
                set.add(i);
            }
            i++;
        }
        return i-1;
    }
}

// Time Limit Exceeded
