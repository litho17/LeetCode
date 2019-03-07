class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            boolean traverse = false; // whether board[j] is in the ship tail
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    if (!traverse) {
                        if (i == 0 || board[i-1][j] == '.') {
                            count++;
                        }
                        traverse = true;
                    }
                } else {
                    traverse = false;
                }
            }
        }
        return count;
    }
}

// Your runtime beats 96.04 % of java submissions.

