public class Board {
    private String[][] board;


    public Board() {
        board = new String[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = "-";
            }
        }
    }

    public void display() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    public boolean isValid(int row, int col) {
        if (col > 3 || col < 1 || row > 3 || row < 1) {
            System.out.println("Out of bounds");
            return false;
        }
        if (board[row - 1][col - 1].equals("-")) {
            return true;
        } else {
            System.out.println("The position is not available");
            return false;

        }
    }

    public void play(int row, int col, String symbol) {
        board[row - 1][col - 1] = symbol;
    }

    public String CheckWin() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != "-") {
                return board[i][1];
            }
        }
        for (int j = 0; j < 3; j++) {
           if (board[0][j]==board[1][j] && board[1][j]==board[2][j] && board[0][j]!="-") {
                return board[0][j];
            }
        }
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("-")) {
            return board[0][0];
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[2][0].equals("-")) {
            return board[0][2];
        }


        return "Nobody won";
    }

    public boolean hasTie(){
        for (int i=0; i<3; i++){
            for (int j=0; j<3; j++){
                if (board[i][j].equals("-")){
                    return false;
                }
            }
         }
        return true;
    }


}

