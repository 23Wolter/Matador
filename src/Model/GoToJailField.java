package Model;


public class GoToJailField implements FieldInterface
{

    private String name;
    private int number;

    public GoToJailField(String name, int number)
    {
        this.name = name;
        this.number = number;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    public int getNumber()
    {
        return number;
    }

    @Override
    public void action(Player actingPlayer)
    {
        actingPlayer.setField(GameDriver.fieldArray[MonopolyConstants.JAIL_POS]);
        actingPlayer.setFreedom(false);
        System.out.println(actingPlayer.getFreedom());

        System.out.println("You are now in jail!");


    }

    public static void getFree(Player actingPlayer, DiceCup cup){

        if(!actingPlayer.getFreedom()) {

            for(int i = 0; i < 3; i++) {
                cup.throwDice();
                System.out.println("\t" + cup);
                if(cup.isEqual()){

                    actingPlayer.setFreedom(true);
                    System.out.println("You are now free");
                    break;
                }
                System.out.println("Too bad, try again");
            }



        }
    }


}
