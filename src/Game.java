import java.util.Scanner;

public class Game {
   private Player player1;
   private Player player2;
   private Board board;
   private Player currentPlayer;


   public Game(){
       board = new Board();
       player1 = initPlayer(1, "-");
       currentPlayer = player1;
       player2 = initPlayer(2, player1.getSymbol());
       start();

   }

   public void start() {
       while (true) {
           play();
           board.display();
           String winner = board.CheckWin();
           if (winner.equals(player1.getSymbol())) {
               System.out.println(player1.getName() + " has won!" );
               player1.addWin();
               initBoard();
           }else if(winner.equals(player2.getSymbol())){
               System.out.println(player2.getName() + "has won");
               player1.addWin();
               initBoard();
           }else if(board.hasTie()){
               System.out.println("It is a tie");
               initBoard();
           }
       }

   }

   public Player initPlayer(int n, String usedSymbol) {
       System.out.println("Enter name of Player " + n + ": ");
       Scanner input = new Scanner(System.in);
       String name = input.nextLine();
       System.out.println("Player " + n + ", enter symbol: ");
       String symbol = input.nextLine();
       while (symbol.equals(usedSymbol) || symbol.equals("-")) {
           System.out.println("Choose again");
           symbol = input.nextLine();
       }
       Player player = new Player(name,symbol);
       return player;
   }

   public void play() {
       Scanner input = new Scanner(System.in);
       System.out.println(currentPlayer.getName() + " plays");
       boolean ok = false;
       int row, col;
       do {
           System.out.println("Choose row");
           row = input.nextInt();
           System.out.println("Choose column");
           col = input.nextInt();
           if(!board.isValid(row, col)) {
               System.out.printf("Invalid position. Try again");
           }
           else {
               ok = true;
           }
       } while(!ok);
       board.play(row,col, currentPlayer.getSymbol());
       changePlayer();
   }

   public void changePlayer() {
       currentPlayer = currentPlayer == player1 ? player2 : player1;
   }

   public void initBoard(){
       board = new Board();
       System.out.println("The score is: " + player1.getWins() + "-" + player2.getWins());
   }

}
