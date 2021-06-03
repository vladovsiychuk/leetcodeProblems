package valid_sudoku_36;

class Solution {
    public static boolean isValid(int row, int col, char num, char[][] board) {

        for(char i = 0; i < 9;i++) {

            //row check
            if(board[row][i] == num) {
                return false;
            }

            //Column Check
            if(board[i][col] == num) {
                return false;
            }
        }
        //Block Check(3*3)
        row = (row/3)*3;
        col = (col/3)*3;
        for(int i = row ; i < row+3 ;i++) {
            for(int j = col ; j < col+3 ; j++) {
                if(board[i][j] == num)return false;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean a = true;

        for(int i = 0 ; i < board.length ;i++) {
            for(int  j = 0 ; j < board.length ;j++) {
                if(board[i][j] != '.') {
                    char temp = board[i][j];
                    board[i][j] = '.';
                    if(isValid(i , j , temp , board)) {
                        board[i][j] = temp;
                    }else {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

