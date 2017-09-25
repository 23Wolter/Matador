package Model;

public class Field {

    private String name;
    private int number;


    public Field(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public int getNumber(){

        return number;
    }
    public String toString() {
        return "Current fieldname: " + name + ", fieldnumber: " + number;
    }
}