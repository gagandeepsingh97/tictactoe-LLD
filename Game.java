import java.util.Scanner;

public class Game {
    private final Player player1;
    private final Player player2;
    private final Board board;
    private Player currentPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = new Board();
        this.currentPlayer = player1;
    }

    public void play() {
        while (!board.isFull() && !board.hasWinner()) {
            System.out.println(currentPlayer.getName() + "'s turn.");
            int row = getValidInput("Enter row(0-2): ");
            int col = getValidInput("Enter column(0-2): ");

            try {
                board.makeMove(row, col, currentPlayer.getSymbol());
                board.printBoard();
                switchPlayer();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        if (board.hasWinner()) {
            switchPlayer();
            System.out.println(currentPlayer.getName() + " wins!");
        } else {
            System.out.println("It's a Draw!");
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private int getValidInput(String message) {
        Scanner sc = new Scanner(System.in);
        int input;

        while (true) {
            System.out.println(message);
            if (sc.hasNextInt()) {
                input = sc.nextInt();
                if (input >= 0 && input <= 2) {
                    return input;
                }
            } else {
                sc.next();
            }
            System.out.println("Invalid input! Please enter a number between 0 and 2.");
        }
    }
}


// For n*n
// class TicTacToe {
//     private int n;
//     private ArrayList<Integer> rowList;
//     private ArrayList<Integer> colList;
//     private int diagonal;
//     private int antiDiagonal;
//     public TicTacToe(int n) {
//         this.n = n;
//         rowList = new ArrayList<>();
//         colList = new ArrayList<>();

//         for (int i = 0; i < n; i++) {
//             rowList.add(0);
//             colList.add(0);
//         }
//     }
    
//     public int move(int row, int col, int player) {
//         if(player == 1) {
//             rowList.set(row, rowList.get(row)+1);
//             colList.set(col, colList.get(col)+1);
//             if(row == col) diagonal++;
//             if(row+col == n-1) antiDiagonal++;
//         }
//         else {
//             rowList.set(row, rowList.get(row)-1);
//             colList.set(col, colList.get(col)-1);
//             if(row == col) diagonal--;
//             if(row+col == n-1) antiDiagonal--;
//         }
//         if(rowList.get(row) == n || colList.get(col) == n || diagonal == n || antiDiagonal == n)
//             return 1;
//         else if(rowList.get(row) == -n || colList.get(col) == -n || diagonal == -n || antiDiagonal == -n)
//             return 2;
//         else
//             return 0;
//     }
// }