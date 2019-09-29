class Solution {
    class MyQueue {
        int[][] ary;
        int count;
        public MyQueue(int len) {
            ary = new int[len][];
            count = 0;
        }
        
        void insert(int[] point) {
            ary[count] = new int[2];
            ary[count][0] = point[0];
            ary[count][1] = point[1];
            int i = count;
            count++;
            int parent = (i-1)/2;
            while (parent>=0 && isLarger(parent, i)) {
                int[] tmp = new int[2];
                tmp[0] = ary[parent][0];
                tmp[1] = ary[parent][1];
                ary[parent][0] = ary[i][0];
                ary[parent][1] = ary[i][1];
                ary[i][0] = tmp[0];
                ary[i][1] = tmp[1];
                i = parent;
                parent = (i-1)/2;
            }
            // System.out.println(ary[0][0]+", "+ary[0][1]);
        }
        
        int[] poll() {
            if (count == 0) return null;
            int[] ret = new int[2];
            ret[0] = ary[0][0];
            ret[1] = ary[0][1];
            count--;
            ary[0][0] = ary[count][0];
            ary[0][1] = ary[count][1];
            int i = 0;
            int left = i*2+1;
            int right = i*2+2;
            // System.out.println(count+" "+(!(left>=count || !isLarger(i, left)) && (right>=count || !isLarger(i, right))));
            while (!((left>=count || !isLarger(i, left)) && (right>=count || !isLarger(i, right)))) {
                // Termination condition: ???
                if (left>=count && right>=count) break;
                boolean isLeftMin = right<count ? isLarger(right, left) : true;
                int child = isLeftMin ? left : right;
                // System.out.println(i+","+ary[i][0]+",,"+ary[i][1]);
                // System.out.println(ary[child][0]+",,,"+ary[child][1]);
                int[] tmp = new int[2];
                tmp[0] = ary[child][0];
                tmp[1] = ary[child][1];
                ary[child][0] = ary[i][0];
                ary[child][1] = ary[i][1];
                ary[i][0] = tmp[0];
                ary[i][1] = tmp[1];
                i = child;
                left = i*2+1;
                right = i*2+2;
            }
            //System.out.println(ary[0][0]+",,"+ary[0][1]);
            return ret;
        }
        
        private boolean isLarger(int idx1, int idx2) {
            int[] p1 = ary[idx1];
            int[] p2 = ary[idx2];
            return (p1[0]*p1[0]+p1[1]*p1[1]) > (p2[0]*p2[0]+p2[1]*p2[1]);
        }
    }
    public int[][] kClosest(int[][] points, int K) {
        MyQueue q = new MyQueue(points.length);
        for (int[] point: points) {
            q.insert(point);
        }
        int[][] res = new int[K][];
        for (int i=0; i<K; i++) {
            res[i] = q.poll();
        }
        return res;
    }
}

// Runtime: 16 ms, faster than 72.81% of Java online submissions for K Closest Points to Origin.
// Memory Usage: 58.3 MB, less than 77.64% of Java online submissions for K Closest Points to Origin.
