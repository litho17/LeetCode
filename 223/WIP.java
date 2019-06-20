class Solution {
    public class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public boolean sameAxis(Point p) {
            return p.x==x || p.y==y;
        }
    }
    
    public class Line {
        Point p1;
        Point p2;
        boolean h;  // is horizontal
        int offset; // offset from origin
        public Line(Point p1, Point p2) {
            this.p1 = p1;
            this.p2 = p2;
            if (p1.y == p2.y) {
                h = true;
                offset = p1.y;
            } else {
                h = false;
                offset = p1.x;
            }
        }
        public Point intersect(Line other) {
            if(h==other.h) return null;
            int y = h? offset : other.offset;
            int x = h? other.offset : offset;
            Point p = new Point(x, y);
            if (contain(p) && other.contain(p)) return p;
            else return null;
        }
        private boolean contain(Point p) {
            if (h) {
                return p.y==offset && ((p.x>=p1.x&&p.x<=p2.x) || (p.x>=p2.x&&p.x<=p1.x));
            } else {
                return p.x==offset && ((p.y>=p1.y&&p.y<=p2.y) || (p.x>=p2.y&&p.x<=p1.y));
            }
        }
    }
    
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        Line aLeft  = new Line(new Point(A, B), new Point(A, D));
        Line aRight = new Line(new Point(C, B), new Point(C, D));
        Line aUp    = new Line(new Point(A, D), new Point(C, D));
        Line aDown  = new Line(new Point(A, B), new Point(C, B));
        Line bLeft  = new Line(new Point(E, F), new Point(E, H));
        Line bRight = new Line(new Point(G, F), new Point(G, H));
        Line bUp    = new Line(new Point(E, H), new Point(G, H));
        Line bDown  = new Line(new Point(E, F), new Point(G, F));
        Point[] points  = new Points[8];
        points[0] = aLeft.intersect(bUp);
        points[1] = aLeft.intersect(bDown);
        points[2] = aRight.intersect(bUp);
        points[3] = aRight.intersect(bDown);
        points[4] = aUp.intersect(bLeft);
        points[5] = aUp.intersect(bRight);
        points[6] = aDown.intersect(bLeft);
        points[7] = aDown.intersect(bRight);
        Point p1 = null;
        Point p2 = null;
        Point p3 = null;
        Point p4 = null;
        for (Point p: points) {
            if (p != null) {
                if (p1==null) p1 = p;
                else if (p2==null) p2 = p;
                else if (p3==null) p3 = p;
                else if (p4==null) p4 = p;
                else assert(false); // Should have at most 2 intersecting points
            }
        }
        int area1 = area(new Point(A, B), new Point(C, D));
        int area2 = area(new Point(E, F), new Point(G, H));
        int res = 0;
        if (p1==null && p2==null) { // One contains another or One is separate from another
            if (A <= E) {
                if (C <= E) { // Separate
                    res = area1+area2;
                } else { // Overlap
                    res = area1;
                }
            } else {
                if (G <= A) { // Separate
                    res = area1+area2;;
                } else { // Overlap
                    res = area2;
                }
            }
        } else if (p1!=null && p2!=null) {
            if (p3!=null) {
                int area3 = (area(p1, p2)+area(p1, p3)+area(p1, p4)+area(p2, p3)+area(p2, p4)+area(p3, p4))/2;
                res = area1+area2-area3;
            } else {
                if (p1.sameAxis(p2)) {
                    if (p1.x == p2.x) {
                        if (p1.x == A) {
                            int a = p1.y-p2.y>=0 ? p1.y-p2.y : p2.y-p1.y;
                            ;
                        } else if (p1.x == C) {
                        } else if (p1.x == E) {
                        } else if (p1.x == G) {
                            ;
                        }
                    } else if (p1.y == p2.y) {
                        ;
                    }
                } else {
                    int area3 = area(p1, p2);
                    res = area1+area2-area3;
                }
            }
        } else assert(false);
        return res;
    }
    
    int area(Point p1, Point p2) {
        int a = p1.x-p2.x>=0 ? p1.x-p2.x : p2.x-p1.x;
        int b = p1.y-p2.y>=0 ? p1.y-p2.y : p2.y-p1.y;
        return a*b;
    }
}

// Why didn't I figure out the solution?
// I know the solution is to find out the intersecting rectangle, but I didn't know how to find its points --- the idea is that, the intersecting rectangle must be inside both rectangles.
// https://www.cnblogs.com/grandyang/p/4563153.html
