package game;

import game.except.CellAlreadyTakenException;

public abstract class TicTacToe {
    
    protected Cell [][] board ;
    protected Choice lineChoice = new Choice();
    public Player player1 , player2, curPlayer;
    protected static final int _LEN = 3, _PLMAYER1 = 1 , _PLMAYER2 = -1;

    public TicTacToe(){
        this.player1 = new Player(TicTacToe._PLMAYER1);
        this.player2 = new Player(TicTacToe._PLMAYER2);
        this.curPlayer =  this.player1;
        this.player1.setBrd(this);
        this.player2.setBrd(this);
        board = new Cell[3][3];
        for (int i = 0; i < TicTacToe._LEN; i++) {
            for (int j = 0; j < TicTacToe._LEN; j++) {
                this.board[i][j] = new Cell(' ');
            }
        }
    }
    public void setTicTacToe(){
        this.curPlayer =  this.player2;
        for (int i = 0; i < TicTacToe._LEN; i++) {
            for (int j = 0; j < TicTacToe._LEN; j++) {
                this.board[i][j] = new Cell(' ');
            }
        }
    }

    public abstract void play();

    /**
     * @return the symbol
     */
    public char getCurrentPlayerSymbol() {
        return this.curPlayer.getSymbol();
    }
    public char getAdverserPlayerSymbol() {
        return (this.curPlayer.getSymbol() == _PLMAYER1)?'O':'X' ;
    }

    public int Check(){
        if  (this.checkRow(this.lineChoice.getRow(), this.getCurrentPlayerSymbol())) return lineChoice.getRow();
        if  (this.checkCol(this.lineChoice.getCol(), this.getCurrentPlayerSymbol())) return (lineChoice.getCol() + 3);
        if  (this.checkDiagonal(this.getCurrentPlayerSymbol())) return 6;
        if  (this.checkDiagonalAnti(this.getCurrentPlayerSymbol())) return 7;
        return -1;
    }

    private boolean checkRow(final int row, final char sym){
        return ( 
               this.board[row][0].getValue() == sym && 
                this.board[row][1].getValue() == sym && 
                this.board[row][2].getValue() == sym
            );
    }

    private boolean checkCol(final int col, final char sym){
        return ( 
                this.board[0][col].getValue() == sym && 
                this.board[1][col].getValue() == sym && 
                this.board[2][col].getValue() == sym)
            ;
    }

    private boolean checkDiagonal( final char sym){
        return ( 
                this.board[0][0].getValue() == sym && 
                this.board[1][1].getValue() == sym && 
                this.board[2][2].getValue() == sym
            );
    }

    private boolean checkDiagonalAnti( final char sym){
            return ( 
                    this.board[2][0].getValue() == sym && 
                    this.board[1][1].getValue() == sym && 
                    this.board[0][2].getValue() == sym
                );
    }

    public void switchPlayer(){
        this.curPlayer =  (this.curPlayer.getId() == player2.getId() )? player1: player2;
    }

    public int go() throws  CellAlreadyTakenException{
        if( this.board[ this.lineChoice.getRow()][ this.lineChoice.getCol()].getValue() != ' ')
            throw new CellAlreadyTakenException();
        this.board[ this.lineChoice.getRow()][ this.lineChoice.getCol()].setValue(this.getCurrentPlayerSymbol());
        return Check();
    }
   
    public class Choice{
        int row, col;
        public Choice(){row = 0 ; col = 0 ;}
        void setChoice(final char r, final char c){ row = Character.getNumericValue(r) -1 ; col = Character.getNumericValue(c) -1 ;}
        void setChoice(final int r, final int c){ row = r ;    col = c;}
        public int getRow(){ return row;}
        public int getCol(){ return col;}
    }
    
}