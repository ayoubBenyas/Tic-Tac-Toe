package src.exception;

public class BoardIndexOutOfBoundsException extends Exception{
    private static final long serialVersionUID = 1L;

    public BoardIndexOutOfBoundsException() {
    }
    @Override
    public String getMessage(){
        return "Board Index Out Of Bounds Exception";
    }
}