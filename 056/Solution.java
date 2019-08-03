class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        List<int[]> ret = new LinkedList<>();
        for (int i=0; i<intervals.length; i++) {
            int[] i1 = intervals[i];
            // if (i==intervals.length-1) ret.add(i1);
            int j;
            for (j=i+1; j<intervals.length; j++) {
                int[] i2 = intervals[j];
                if (i1[0]<=i2[0] && i2[0]<=i1[1]) {
                    int[] i3 = new int[2];
                    i3[0] = i1[0];
                    i3[1] = i2[1]<=i1[1] ? i1[1] : i2[1];
                    i1 = i3;
                } else {
                    ret.add(i1);
                    break;
                }
            }
            // [0, j) have been merged
            if (j==intervals.length) {
                ret.add(i1);
                break;
            } else i = j-1;
        }
        int[][] res = new int[ret.size()][];
        for (int i=0; i<ret.size(); i++) {
            res[i] = ret.get(i);
        }
        return res;
    }
}

// Runtime: 7 ms, faster than 75.10% of Java online submissions for Merge Intervals.
// Memory Usage: 45.4 MB, less than 27.72% of Java online submissions for Merge Intervals.
