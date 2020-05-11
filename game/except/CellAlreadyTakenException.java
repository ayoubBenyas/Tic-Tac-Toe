package game.except;

public class CellAlreadyTakenException extends Exception{
    private static final long serialVersionUID = 1L;

    public CellAlreadyTakenException() {
    }
    @Override
    public String getMessage(){
        return "Cell Has Been Already Taken";
    }
}