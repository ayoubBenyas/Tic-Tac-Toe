package game;

public class Cell{
    char value;
    public Cell(char sym){
        this.value = sym;
    }
    /**
     * @return the value
     */
    public char getValue() {
        return this.value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(char value) {
        this.value = value;
    }
}