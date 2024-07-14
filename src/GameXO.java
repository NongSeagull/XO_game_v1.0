/**********************************************
 * Author : Piyapong Thongman (65160230)
 * Program : XO game
 ***********************************************/
import java.utill.*;
public class GameXO {
    //method
    public static void setUpBoard(char[][] board) {
        System.out.print("=== Welcome to OX Game ===");
        System.out.println();
        int row, col;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board.length; col++) {
                board[row][col] = '-';
            }
        }
    }
    public static void printBoard(char[][] board) {
        int row;
        int col;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board.length; col++) {
                System.out.printf("%-4s%-2c%-2s","|" , board[row][col] , " ");
            }
            System.out.printf("%-2s","|");
            System.out.println();
        }
    }
    public static void checkPlayerTurn(char player) {
        if (player == 'X') {
            System.out.printf("%-2s%-2s" ," ", "---- It's X turn ----");
            System.out.println();
        } else {
            System.out.printf("%-2s%-2s" ," ", "---- It's O turn ----");
            System.out.println();
        }
    }
    public static char currentPlayer(boolean checkPlayer) {
        if (checkPlayer == true) {
            return 'X';
        } else {
            return 'O';
        }
    }
    public static boolean switchPlayer(char player){
        if(player == 'X'){
            return false;
        }else{
            return true;
        }
    }
    public static String checkBoardFull(char[][] board) {
        int row, col;
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board.length; col++) {
                if (board[row][col] == '-') {
                    return "not full";
                }
            }
        }
        return "full";
    }
    public static boolean checkRowWinner(char[][] board, char player) {
        int col;
        for (col = 0; col < board.length; col++) {
            if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkColWinner(char[][] board, char player) {
        int row;
        for (row = 0; row < board.length; row++) {
            if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonalWinner(char[][] board, char player) {
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }else if(board[2][0] == player && board[1][1] == player && board[0][2] == player) {
            return true;
        }
        return false;
    }

    //main
    public static void main(String[] args) {
        //variable
        /*scanner*/
        Scanner kb = new Scanner(System.in);
        /*create board with 3 x 3*/
        char[][] board = new char[3][3];
        /*row and column */
        int row = 0;
        int col = 0;
        /*position 1 and 2*/
        int position1;
        int position2;
        /*player variable*/
        char player;
        /*switch player*/
        boolean switchPlayer = true; //true: X , false: O

        //show welcome text and set up blank board
        setUpBoard(board);
        while (true) {
            //check board is full or not
            if (checkBoardFull(board).equals("full")) {
                //board are full
                printBoard(board);
                System.out.printf("%-2s%-2s" ," ", "---- It's a Draw ----");
                System.out.println();
                break;
            }else{
                //board not full
                //config player (start with X)
                player = currentPlayer(switchPlayer);

                //print board
                printBoard(board);

                //check player turn
                checkPlayerTurn(player);

                //input row and column
                System.out.print("input row and column : ");
                position1 = kb.nextInt();
                position2 = kb.nextInt();
            }

            if (position1 > board.length || position2 > board.length || position1 < 1 || position2 < 1) {
                //index out of bound
                System.out.println("Your input is out of bounds, please try again.");
                continue;
            } else if (board[position1 - 1][position2 - 1] != ('-')) {
                //position is already exit
                System.out.println("this position is already exist, please try again.");
                continue;
            } else {
                //insert player to board
                board[position1 - 1][position2 - 1] = player;

                /*check player are win or not*/
                //if player have win program will show board, show winner and end game
                if(checkRowWinner(board, player)){
                    printBoard(board);
                    System.out.println("-- " + player + " wins with a row win --");
                }else if (checkColWinner(board, player)) {
                    printBoard(board);
                    System.out.println("-- " + player + " wins with a column win --");
                    break;
                }else if(checkDiagonalWinner(board, player)) {
                    printBoard(board);
                    System.out.println("-- " + player + " wins with a diagonal win --");
                    break;
                }else{
                    //if not win program will switch player
                    switchPlayer = switchPlayer(player);
                }
            }
        }
    }
}
