class Solution {
    public boolean validTicTacToe(String[] board) {
        char[][] board_ = new char[3][3];
        int numX = 0;
        int numO = 0;
        int numE = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                board_[i][j] = board[i].charAt(j);
                if (board_[i][j] == 'X') numX++;
                else if (board_[i][j] == 'O') numO++;
                else numE++;
            }
        }
        if (numO<=numX && numX<=numO+1) {
            int winnerX = 0;
            int winnerO = 0;
                for (int i=0; i<3; i++) {
                    if (board_[i][0]!=' ' && board_[i][0]==board_[i][1] && board_[i][1]==board_[i][2]) {
                        if (board_[i][0]=='X') winnerX++;
                        else winnerO++;
                    }
                }
                for (int i=0; i<3; i++) {
                    if (board_[0][i]!=' ' && board_[0][i]==board_[1][i] && board_[1][i]==board_[2][i]) {
                        if (board_[0][i]=='X') winnerX++;
                        else winnerO++;
                    }
                }
                if (board_[0][0]!=' ' && board_[0][0]==board_[1][1] && board_[1][1]==board_[2][2]) {
                    if (board_[0][0]=='X') winnerX++;
                    else winnerO++;
                }
                if (board_[0][2]!=' ' && board_[0][2]==board_[1][1] && board_[1][1]==board_[2][0]) {
                    if (board_[0][2]=='X') winnerX++;
                    else winnerO++;
                }
            // System.out.println(winnerX+" "+winnerO);
            if (winnerX>0 && winnerO>0) return false;
            else {
                // if (winnerX==0 && winnerO==0) return true;
                
                if (winnerX>0) {
                    return numX>numO;
                } else if (winnerO>0) {
                    return numX==numO;
                }
                return true;
            }
        } else return false;
    }
}

// Runtime: 0 ms, faster than 100.00% of Java online submissions for Valid Tic-Tac-Toe State.
// Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Valid Tic-Tac-Toe State.
