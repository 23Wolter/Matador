package Model;

public class Player {

    private String name;
    private Field currentField;
    //private FieldInterface currentField;

    public Player (String name, Field currentField){

        this.name = name;
        this.currentField = currentField;
    }


    public int move(DiceCup cup) {

        return cup.throwDice();
    }

    public void setField (Field newField){
        currentField = newField;
    }

    public Field getField() {
        return currentField;
    }

    public int getFieldNumber () {return currentField.getNumber();}

    public String getName () {return name;}

    public void setPos(int moves) {



    }
}
