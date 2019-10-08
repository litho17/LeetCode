class Solution {
    class MaxHeap {
        int[] ary;
        int count;
        public MaxHeap(int n) {
            ary = new int[n];
            count = 0;
        }
        void insert(int n) {
            ary[count] = n;
            int i = count;
            int parent = (i-1)/2;
            while (parent>=0 && parent<i && ary[parent]<ary[i]) {
                int tmp = ary[parent];
                ary[parent] = ary[i];
                ary[i] = tmp;
                i = parent;
                parent = (i-1)/2;
            }
            
            count++;
        }
        int poll() {
            count--;
            int ret = ary[0];
            ary[0] = ary[count];
            if (count<=1) return ret;
            
            int i = 0;
            int left = 2*i+1;
            int right = 2*i+2;
            while (!((left>=count || ary[i]>=ary[left]) && (right>=count || ary[i]>=ary[right]))) {
                if (left>=count) break;
                int max = ary[left]; // Check array access
                if (right<count && ary[right]>max) {
                    max = ary[right];
                }
                int maxIdx = max==ary[left] ? left : right;
                /*for (int j=0; j<count; j++) {
                    System.out.print(ary[j]+" ");
                }*/
                System.out.println();
                int tmp = ary[i];
                ary[i] = max;
                ary[maxIdx] = tmp;
                i = maxIdx;
                left = 2*i+1;
                right = 2*i+2;
            }
            return ret;
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
        MaxHeap h = new MaxHeap(nums.length);
        for (int num: nums) {
            h.insert(num);
            // System.out.println(h.ary[0]);
        }
        int ret = -1;
        for (int i=0; i<k; i++) {
            ret = h.poll();
            //System.out.println(ret);
        }
        return ret;
    }
}

// Runtime: 138 ms, faster than 5.22% of Java online submissions for Kth Largest Element in an Array.
// Memory Usage: 38.1 MB, less than 50.26% of Java online submissions for Kth Largest Element in an Array.
