class Solution {
    class Pair {
        int x,y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    public boolean exist(char[][] board, String word) {
        if (word.length()==0) return true;
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j]==word.charAt(0)) {
                    Set<Pair> path = new HashSet<Pair>();
                    path.add(new Pair(i,j));
                    boolean res = helper(i, j, board, word, 1, path);
                    if (res) return true;
                }
            }
        }
        return false;
    }
    
    boolean helper(int x, int y, char[][] board, String word, int nxtIdx, Set<Pair> path) {
        // System.out.println(x+" "+y);
        assert(nxtIdx>=1 && board[x][y]==word.charAt(nxtIdx-1));
        if (nxtIdx==word.length()) return true;
        Pair p1 = new Pair(x-1,y);
        Pair p2 = new Pair(x+1,y);
        Pair p3 = new Pair(x,y-1);
        Pair p4 = new Pair(x,y+1);
        List<Pair> l = new LinkedList<>();
        l.add(p1);
        l.add(p2);
        l.add(p3);
        l.add(p4);
        for (Pair p: l) {
            if (p.x>=0 && p.x<board.length && p.y>=0 && p.y<board[0].length && board[p.x][p.y]==word.charAt(nxtIdx)) {
                boolean visited = false;
                for (Pair pp: path) {
                    if (pp.x==p.x && pp.y==p.y) {
                        visited = true;
                        break;
                    }
                }
                if (visited) continue;
                Set<Pair> newPath = new HashSet<>(path);
                newPath.add(p);
                boolean res = helper(p.x, p.y, board, word, nxtIdx+1, newPath);
                if (res) return true;
            }
        }
        return false;
    }
}

// Runtime: 138 ms, faster than 6.04% of Java online submissions for Word Search.
// Memory Usage: 52 MB, less than 6.11% of Java online submissions for Word Search.
