class Solution {
    class Pair {
        int x,y;
        public Pair(int x, int y) {
            this.x=x;
            this.y=y;
        }
    }
    public void solve(char[][] board) {
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                // Nodes marked as '~' are known to be connected with borders
                // Nodes marked as 'O' are isolated from all visited 'O' nodes
                if (board[i][j]=='O') {
                    if (i==0||j==0||i==board.length-1||j==board[0].length-1) board[i][j]='~';
                    else { // DFS only 'O' nodes
                        boolean shouldMark = true;
                        Stack<Pair> stack = new Stack<>(); // Each node in stack is 'O' node
                        stack.push(new Pair(i,j));
                        Set<Pair> visited = new HashSet<>();
                        // System.out.println("\n"+i+" "+j);
                        while (!stack.isEmpty()) {
                            Pair top = stack.pop();
                            board[top.x][top.y] = 'Z';
                            visited.add(top);
                            // System.out.println(top.x+" "+top.y);
                            if (top.x>0) {
                                if (board[top.x-1][top.y]=='~') shouldMark = false;
                                if (board[top.x-1][top.y]=='O') stack.push(new Pair(top.x-1,top.y));
                            }
                            if (top.x<board.length-1) {
                                if (board[top.x+1][top.y]=='~') shouldMark = false;
                                if (board[top.x+1][top.y]=='O') stack.push(new Pair(top.x+1,top.y));
                            }
                            if (top.y>0) {
                                if (board[top.x][top.y-1]=='~') shouldMark = false;
                                if (board[top.x][top.y-1]=='O') stack.push(new Pair(top.x,top.y-1));
                            }
                            if (top.y<board[0].length-1) {
                                if (board[top.x][top.y+1]=='~') shouldMark = false;
                                if (board[top.x][top.y+1]=='O') stack.push(new Pair(top.x,top.y+1));
                            }
                        }
                        // If connected with borders
                        for (Pair p: visited) {
                            if (p.x==0 || p.x==board.length-1 || p.y==0 || p.y==board[0].length-1) {
                                shouldMark = false;
                                break;
                            }
                        }
                        for (Pair p: visited) {
                            board[p.x][p.y] = shouldMark ? 'X' : '~';
                        }
                    }
                }
            }
        }
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]=='~') board[i][j] = 'O';
            }
        }
    }
}

// Runtime: 37 ms, faster than 5.28% of Java online submissions for Surrounded Regions.
// Memory Usage: 52 MB, less than 5.05% of Java online submissions for Surrounded Regions.

