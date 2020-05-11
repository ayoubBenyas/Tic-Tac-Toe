import src.main.*;

public class Main{
    public static void main(String[] args) {
        TicTacToe Game;
        Game = new ConsoleTicTacToe();
        //Game = new GraphicTicTacToe();
        Game.play();
    }
}