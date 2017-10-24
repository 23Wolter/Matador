package Model;

public class Player {

    private String name;
    private FieldInterface currentField;
    private int money;
    private boolean isFree = true;
    //private FieldInterface currentField;

    public Player (String name, FieldInterface currentField, int money){

        this.name = name;
        this.currentField = currentField;
        this.money = money;
    }


    public int move(DiceCup cup) {

        return cup.throwDice();
    }

    public void setField (FieldInterface newField){
        currentField = newField;
    }

    public FieldInterface getField() {
        return currentField;
    }

    public int getFieldNumber () {return currentField.getNumber();}

    public String getName () {return name;}

    public boolean getFreedom () {return isFree;}

    public void setFreedom (boolean freedom){ isFree = freedom;}

    public int getMoney() {
        return money;
    }

    public void addMoney(int amount) {
        money += amount;
    }

    public void takeMoney(int amount) {
        money -= amount;
    }
}
