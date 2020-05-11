package game;

public class Player {
    int id;
    char  symbol;
    TicTacToe brd;

    public Player(int i){
        this.id = i;
        this.symbol = (i == 1)?'X':'O';
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the symbol
     */
    public char getSymbol() {
        return symbol;
    }

    /**
     * @param b the b to set
     */
    public void setBrd(TicTacToe b) {
        this.brd = b;
    }

    public String toString(){
        return String.format("Player : %d",this.getId());
    }

}