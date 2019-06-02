class Solution {
    class Pair {
        int l;
        int r;
        public Pair(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    
    public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<Pair> res = new LinkedList<Pair>();
        int nextA = 0;
        int nextB = 0;
        while (nextB < B.length && nextA < A.length) {
            // System.out.println(nextA + " " + nextB);
            if (B[nextB][0] < A[nextA][0]) { // B_left < A_left
                if (B[nextB][1] < A[nextA][0]) { // B_right < A_left
                    nextB++;
                } else { // B_right ≥ A_left
                    if (B[nextB][1] < A[nextA][1]) { // B_right < A_right
                        res.add(new Pair(A[nextA][0], B[nextB][1]));
                        nextB++;
                    } else { // B_right ≥ A_right
                        res.add(new Pair(A[nextA][0], A[nextA][1]));
                        nextA++;
                    }
                }
            } else { // B_left ≥ A_left
                if (B[nextB][0] > A[nextA][1]) { // B_left > A_right
                    nextA++;
                } else { // B_left ≤ A_right
                    if (B[nextB][1] < A[nextA][1]) { // B_right < A_right
                        res.add(new Pair(B[nextB][0], B[nextB][1]));
                        nextB++;
                    } else { // B_right ≥ A_right
                        res.add(new Pair(B[nextB][0], A[nextA][1]));
                        nextA++;
                    }
                }
            }
        }
        
        int[][] arr = new int[res.size()][2];
        for (int i = 0; i < res.size(); i++) {
            arr[i][0] = res.get(i).l;
            arr[i][1] = res.get(i).r;
        }
        return arr;
    }
}

// Runtime: 7 ms, faster than 11.44% of Java online submissions for Interval List Intersections.
// Memory Usage: 40.3 MB, less than 99.12% of Java online submissions for Interval List Intersections.
