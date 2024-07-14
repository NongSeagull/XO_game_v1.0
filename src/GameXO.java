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
        printBoard(board);
    }
}
