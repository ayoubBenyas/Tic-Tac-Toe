package game;

import java.util.Scanner;
import game.except.*;

public class ConsoleTicTacToe extends TicTacToe{
    
    public ConsoleTicTacToe(){
        super();
        this.display();    
    }

    public void display(){
        System.out.print( 
            String.format("\t\t    1   2    3\n")+
            String.format("\t\t  +---+---+---+\n")+
            String.format("\t\t1 | %c | %c | %c |\n", this.board[0][0].getValue(), this.board[0][1].getValue(), this.board[0][2].getValue())+
            String.format("\t\t  +---+---+---+\n")+
            String.format("\t\t2 | %c | %c | %c |\n", this.board[1][0].getValue(), this.board[1][1].getValue(), this.board[1][2].getValue())+
            String.format("\t\t  +---+---+---+\n")+
            String.format("\t\t3 | %c | %c | %c |\n", this.board[2][0].getValue(), this.board[2][1].getValue(), this.board[2][2].getValue())+
            String.format("\t\t  +---+---+---+\n")+
            String.format("%c's turn , last play : [%d, %d; %c]", this.getCurrentPlayerSymbol(),this.lineChoice.getRow()+1, lineChoice.getCol()+1, this.getAdverserPlayerSymbol())
        );
    }

    public void getChoice() throws BoardIndexOutOfBoundsException, MissingInputException{
        String [] line;
        Scanner scan = new Scanner(System.in);
        System.out.print("\n:>\t");

        try {
            line = scan.nextLine().trim().split(" ", 2);
            if(line.length <2)
                throw new MissingInputException();
            
            if(
                !( line[0].length() == 1 && '1' <= line[0].charAt(0) && line[0].charAt(0) <= '3'  )||
                !( line[1].length() == 1 && '1' <= line[1].charAt(0) && line[1].charAt(0) <= '3'  )
            )
                throw new BoardIndexOutOfBoundsException();
            
            lineChoice.setChoice(line[0].charAt(0),  line[1].charAt(0));
        } catch (StringIndexOutOfBoundsException e1) {
            System.err.print("String Index Out Of Bounds Exception");
        } catch (ArrayIndexOutOfBoundsException e2) {
            System.err.print("Array Index Out Of Bounds Exception");
        }    
    }
    
    public void play(){
        while(true){//loop game
            try {
                this.getChoice();
                if (this.go() > -1){
                    break; //quit loop game
                }else{
                    this.switchPlayer();
                }
                this.display();
            } 
            catch (CellAlreadyTakenException e) {
                System.err.print(e.getMessage());
            }
            catch (BoardIndexOutOfBoundsException e) {
                System.err.print(e.getMessage());
            }
            catch (MissingInputException e) {
                System.err.print(e.getMessage());
            }
        }
        this.display();
        System.out.print(String.format(":);):);):):)\tweeeeeeeh %c win!!!!!",this.getCurrentPlayerSymbol()));
    }

}