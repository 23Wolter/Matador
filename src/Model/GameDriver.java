package Model;

public class GameDriver {

    private static Field[] fieldArray = new Field[40];


    
    public static  void main(String[] args){

        //Opretter et array med alle spilfelter
        for (int i = 0; i < fieldArray.length; i++){
            fieldArray[i] = new Field("Field"+i,i);
        }


        //Opretter to spillere med et navn og en plads
        Player player1 = new Player("Josephine",fieldArray[0]);
        Player player2 = new Player("Oliver",fieldArray[0]);


        //Henter spillerens braet-nummer
        int playerField1 = player1.getFieldNumber();
        int playerField2 = player2.getFieldNumber();

        //Opretter en kop med to terninger med seks sider hver
        DiceCup cup = new DiceCup(6);
        DiceCup cup2 = new DiceCup(6);

        //Holder styr på spilrunder
        int count = 1;

        //Game loop
        while(playerField1<40 || playerField2<40){

            //Bestemmer hvor langt spilleren skal rykke
            int fieldToMove1 = playerField1 + player1.move(cup);
            int fieldToMove2 = playerField2 + player2.move(cup2);


            // Kode der printer spillet ud
            System.out.println("Game round " + count);

            System.out.println(player1.getName());
            System.out.println("\t" + cup);
            System.out.println("Move to: " + fieldToMove1);

            System.out.println("");

            System.out.println(player2.getName());
            System.out.println("\t" + cup2);
            System.out.println("Move to: " + fieldToMove2);

            System.out.println("");
            System.out.println("---------------------------");
            System.out.println("");


            //Tjekker om spillerne er kommet forbi start
            if(fieldToMove1>=40){
                System.out.println(player1.getName()+" Wins");
                break;
            } else if(fieldToMove2>=40){
                System.out.println(player2.getName()+" Wins");
                break;
            }

            //Sætter spillernes nye positioner
            player1.setField(fieldArray[fieldToMove1]);
            player2.setField(fieldArray[fieldToMove2]);



            //Henter spillerens braet-nummer
            playerField1 = player1.getFieldNumber();
            playerField2 = player2.getFieldNumber();

            count++;
        }
    }
}
