public class Player {
    private String name;
    private int wins;
    private String symbol;

   public Player(String name, String symbol){
        this.name=name;
        this.symbol=symbol;
        this.wins=0;
    }

    public String getName() {
        return name;
    }

    public int getWins() {
        return wins;
    }

    public String getSymbol() {
        return symbol;
    }
    public void addWin(){
       wins++;
    }
}
