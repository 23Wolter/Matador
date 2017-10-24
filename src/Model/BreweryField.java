package Model;

public class BreweryField extends OwnableField implements FieldInterface {

    private int rentToPay;

    protected BreweryField(String name, int number, int price, int rent) {
        super(name, number, price, rent);
    }

    @Override
    public void action(Player actingPlayer) {
        Player owner = super.getOwner();
        if(owner != null) {
            if(owner == actingPlayer) {
                System.out.println("You already own this brewery: " + getName() + "!");
            } else {
                System.out.println("You have to pay the current brewery owner: " + owner.getName() + "!");
                DiceCup c = new DiceCup(6);
                int result = c.throwDice();
                System.out.println("Rent is calculated by dice throw");
                System.out.println("\t" + c);
                rentToPay = result * 10;
                System.out.println("Rent is: " + result + " * 10 = " + rentToPay);
                actingPlayer.takeMoney(rentToPay);
                owner.addMoney(rentToPay);
            }
        } else {
            System.out.println("You now own this brewery: " + getName() + ", pay " + getPrice() + "!");
            actingPlayer.takeMoney(getPrice());
            setOwner(actingPlayer);
        }
    }
}
