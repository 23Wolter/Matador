package Model;

public class ShipField extends OwnableField implements FieldInterface {

    protected ShipField(String name, int number, int price, int rent) {
        super(name, number, price, rent);
    }

    @Override
    public void action(Player actingPlayer) {
        Player owner = super.getOwner();
        if(owner != null) {
            if(owner == actingPlayer) {
                System.out.println("You already own this ship: " + getName() + "!");
            } else {
                System.out.println("You have to pay the current ship owner: " + owner.getName() + ", " + getRent() + "!");
                actingPlayer.takeMoney(getRent());
                owner.addMoney(getRent());
            }
        } else {
            System.out.println("You now own this ship: " + getName() + ", pay " + getPrice() + "!");
            actingPlayer.takeMoney(getPrice());
            setOwner(actingPlayer);
        }
    }
}
