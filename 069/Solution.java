class Solution {
    public int mySqrt(int x) {
        assert (x>=0);
        long i = 0;
        long xp = (long)x;
        while (i*i<=xp) {
            i++;
        }
        return (int)i-1;
    }
}

// Runtime: 12 ms, faster than 10.53% of Java online submissions for Sqrt(x).
// Memory Usage: 33.6 MB, less than 5.14% of Java online submissions for Sqrt(x).

