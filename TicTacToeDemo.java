public class TicTacToeDemo {
    public static void main(String[] args) {
        Player player1 = new Player("Gagan", 'X');
        Player player2 = new Player("Pardeep", 'O');

        Game game = new Game(player1, player2);
        game.play();
    }
}
