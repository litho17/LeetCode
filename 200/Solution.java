class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        char COLOR = '~';
        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j]=='1') {
                    count++;
                    // DFS explore and mark all connected points with COLOR
                    Stack<Point> stack = new Stack<>();
                    stack.push(new Point(i, j));
                    while (!stack.isEmpty()) {
                        Point p = stack.pop();
                        grid[p.x][p.y] = COLOR;
                        for (Point n: p.neighbors(grid)) {
                            stack.push(n);
                        }
                    }
                }
            }
        }
        return count;
    }
    
    class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public List<Point> neighbors(char[][] grid) {
            // Valid neighbors that have not yet been marked (i.e. visited) and are not 0
            List<Point> ret = new LinkedList<>();
            int row = grid.length;
            int col = grid[0].length;
            if (isValid(x+1,y,row,col) && grid[x+1][y]=='1') ret.add(new Point(x+1, y));
            if (isValid(x-1,y,row,col) && grid[x-1][y]=='1') ret.add(new Point(x-1, y));
            if (isValid(x,y+1,row,col) && grid[x][y+1]=='1') ret.add(new Point(x, y+1));
            if (isValid(x,y-1,row,col) && grid[x][y-1]=='1') ret.add(new Point(x, y-1));
            return ret;
        }
        private boolean isValid(int x, int y, int row, int col) {
            return x>=0 && x<row && y>=0 && y<col;
        }
    }
}

// Runtime: 9 ms, faster than 5.40% of Java online submissions for Number of Islands.
// Memory Usage: 41 MB, less than 74.81% of Java online submissions for Number of Islands.

// My code is slow because I created a class, not because the algorithm is not optimal
