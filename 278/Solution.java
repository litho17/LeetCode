/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        long res = helper(1L, (long)n, (long)n);
        if (res == -1L) return n;
        else return (int)res;
    }
    
    long helper(long start, long end, long n) {
        if (start>end || start<1 || end>n) return -1;
        
        long mid = (start+end)/2;
        if (isBadVersion((int)mid)) {
            long res = helper(1, mid-1, n);
            if (res == -1) return mid;
            else return res;
        }
        else {
            return helper(mid+1, end, n);
        }
    }
}

// Runtime: 62 ms, faster than 5.30% of Java online submissions for First Bad Version.
// Memory Usage: 32.9 MB, less than 100.00% of Java online submissions for First Bad Version.
