class Solution {
    public int shipWithinDays(int[] weights, int D) {
        if (weights.length == 1) return weights[0];
        int start = 1;
        int end = 0;
        for (int i=0; i<weights.length; i++) {
            end += weights[i];
        }
        return binSearch(start, end, weights, D);
    }

    int binSearch(int start, int end, int[] weights, int D) {
        if (start>end) return -1;
        if (start==end) return start;
        if (isValid(start, weights, D)) return start;
        if (!isValid(end, weights, D)) return -1;
        int mid = (start+end)/2;
        if (isValid(mid, weights, D)) {
            if (start+1>mid) return mid;
            else return binSearch(start+1, mid, weights, D);
        }
        else {
            if (mid+1>end) return end;
            else return binSearch(mid+1, end, weights, D);
        }
    }

    boolean isValid(int W, int[] weights, int D) {
        int count = 0; // # of bins that have been used
        int sum = 0;
        for (int i=0; i<weights.length && count<=D; i++) {
            if (weights[i] > W) return false;
            
            if (sum+weights[i] > W) {
                count++;
                sum = weights[i];
            }
            else {
                if (sum == 0) count++;
                sum += weights[i];
            }
            // weight[i] is packed
        }
        return count <= D;
    }
}

// Runtime: 15 ms, faster than 35.45% of Java online submissions for Capacity To Ship Packages Within D Days.
// Memory Usage: 43.5 MB, less than 53.85% of Java online submissions for Capacity To Ship Packages Within D Days.
