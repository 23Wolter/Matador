package Model;

public class OtherField implements FieldInterface {

    private String name;
    private int number;

    public OtherField(String name, int number) {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void action(Player actingPlayer) {
        switch (number+1) {
            case 1:
                //start
                System.out.println("You are on Start!");
                break;
            case 4:
                //indkomstskat
                System.out.println("You have to pay tax!");
                break;
            case 11:
                //fængsel
                System.out.println("Visiting jail!");
                break;
            case 39:
                //ekstra skat
                System.out.println("Pay extraordinary tax!");
                break;
            default:
                //prøv lykken
                System.out.println("Prøv Lykken!");
        }
    }
}
