package Model;


public abstract class OwnableField implements FieldInterface{
    private String name;
    private int number;
    private int price;
    private int rent;
    private Player owner;

    protected OwnableField(String name, int number, int price, int rent)
    {
        this.name = name;
        this.number = number;
        this.price = price;
        this.rent = rent;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public int getNumber()
    {
        return number;
    }

    public int getPrice()
    {
        return price;
    }

    public int getRent() { return rent; }

    public Player getOwner()
    {
        return owner;
    }

    public void setOwner(Player newOwner)
    {
        this.owner = newOwner;
    }

}
