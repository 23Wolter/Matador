package Model;


public class StreetField extends OwnableField {

    protected StreetField(String name, int number, int price, int rent)
    {
        super(name, number, price, rent);
    }

    @Override
    public void action(Player actingPlayer) {
        Player owner = super.getOwner();
        if(owner != null) {
            if(owner == actingPlayer) {
                System.out.println("You already own " + getName() + "!");
            } else {
                System.out.println("You have to pay " + owner.getName() + " " + getRent() + "!");
                actingPlayer.takeMoney(getRent());
                owner.addMoney(getRent());
            }
        } else {
            System.out.println("You are now the owner of " + getName() + ", pay " + getPrice());
            actingPlayer.takeMoney(getPrice());
            setOwner(actingPlayer);
        }
    }
}
