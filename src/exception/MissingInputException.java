package src.exception;

public class MissingInputException extends Exception{
    private static final long serialVersionUID = 1L;

    public MissingInputException() {
    }
    @Override
    public String getMessage(){
        return "Missing Input Exception";
    }
}