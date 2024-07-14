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
        }
    }
}
