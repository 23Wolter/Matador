package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameDriver {

    private static String filename = "MonopolyData.txt";

    public static FieldInterface[] fieldArray = new FieldInterface[40];



    public static void fillFields() {

        try {
            Scanner inputStream = new Scanner(new File(filename));

            int i = 0;
            while(inputStream.hasNextLine()){

                String line = inputStream.nextLine();
                String[] ary = line.split("\t");

                int number = 0;
                number = Integer.parseInt(ary[0]);

                String name = "";
                name = ary[1];

                String type = "";
                type = ary[2];

                int price = 0;
                int rent = 0;

                if(ary.length >= 4) {
                    price = Integer.parseInt(ary[3]);
                    if(ary.length == 5) {
                        rent = Integer.parseInt(ary[4]);
                        System.out.println(number + " " + name + " " + type + " " + price + " " + rent);
                    }else
                    System.out.println(number + " " + name + " " + type + " " + price );
                }else
                System.out.println(number + " " + name + " " + type);

            //Alle felter er StreetField lige nu
                switch (i+1) {
                //Andre felter
                case 1:
                case 3:
                case 5:
                case 8:
                case 11:
                case 18:
                case 21:
                case 23:
                case 34:
                case 37:
                case 39:
                    fieldArray[i] = new OtherField(name, number);
                    break;
                case 31:
                    fieldArray[i] = new GoToJailField(name,number);
                    break;
                case 6:
                case 16:
                case 26:
                case 36:
                    fieldArray[i] = new ShipField(name, number, price, rent);
                    break;
                case 13:
                case 29:
                    fieldArray[i] = new BreweryField(name, number, price, rent);
                    break;
                default:
                    fieldArray[i] = new StreetField(name, number, price, rent);
                }

                i++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }



    public static  void main(String[] args){

        fillFields();



        //Opretter to spillere med et navn og en plads
        Player player1 = new Player("Josephine",fieldArray[0], MonopolyConstants.START_MONEY);
        Player player2 = new Player("Oliver",fieldArray[0], MonopolyConstants.START_MONEY);


        //Henter spillerens braet-nummer
        int playerField1 = player1.getFieldNumber();
        int playerField2 = player2.getFieldNumber();

        //Opretter en kop med to terninger med seks sider hver
        DiceCup cup = new DiceCup(6);
        DiceCup cup2 = new DiceCup(6);

        //Holder styr på spilrunder
        int count = 1;
        int gameboardRounds = 0;

        //Game loop
        while(gameboardRounds < 10){

            // Kode der printer spillet ud
            System.out.println("Game round " + count);




            //tjekker om spiller1 er i fængsel og ikke fri
            if(playerField1 == MonopolyConstants.JAIL_POS && !player1.getFreedom()){

                //forsøg at komme fri
                GoToJailField.getFree(player1, cup);

            } else {

                //Bestemmer hvor langt spilleren skal rykke
                int fieldToMove1 = playerField1 + player1.move(cup);

                // Kode der printer spillet ud
                System.out.println(player1.getName());
                System.out.println("Money: " + player1.getMoney());
                System.out.println("\t" + cup);

                //tjekker om start er passeret
                if(fieldToMove1 > 40) {
                    gameboardRounds++;
                    System.out.println("You passed Start! Collect " + MonopolyConstants.PASSING_START);
                    player1.addMoney(MonopolyConstants.PASSING_START);
                }

                //kører forfra på brættet
                fieldToMove1 = fieldToMove1 % 40;
                System.out.println("Moved to: " + (fieldToMove1+1));

                //opdaterer position
                player1.setField(fieldArray[fieldToMove1]);
                player1.getField().action(player1);

                System.out.println("");
            }


            //tjekker om spiller2 er i fængsel og ikke fri
            if (playerField2 == MonopolyConstants.JAIL_POS && !player2.getFreedom()){

                //forsøg at komme fri
                GoToJailField.getFree(player2, cup2);

            } else {

                //Bestemmer hvor langt spilleren skal rykke
                int fieldToMove2 = playerField2 + player2.move(cup2);

                // Kode der printer spillet ud
                System.out.println(player2.getName());
                System.out.println("Money: " + player2.getMoney());
                System.out.println("\t" + cup2);

                //tjekker om start er passeret
                if(fieldToMove2 > 40) {
                    gameboardRounds++;
                    System.out.println("You passed Start! Collect " + MonopolyConstants.PASSING_START);
                    player2.addMoney(MonopolyConstants.PASSING_START);
                }

                //kører forfra på spillepladen
                fieldToMove2 = fieldToMove2 % 40;
                System.out.println("Moved to: " + (fieldToMove2+1));

                //opdaterer position
                player2.setField(fieldArray[fieldToMove2]);
                player2.getField().action(player2);
            }





            System.out.println("");
            System.out.println("---------------------------");
            System.out.println("");

            //Henter spillerens braet-nummer
            playerField1 = player1.getFieldNumber();
            playerField2 = player2.getFieldNumber();

            count++;
        }
    }
}
