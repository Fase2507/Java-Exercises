package  Tutorial;

import java.util.Random;
import java.util.Scanner;

// java dice roller
    // display ascii
class DiceRoller{
    public static void main(String[] args){
        phoneKeys();
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int total=0;
        int numOfdice;

        System.out.println("Enter # for dice: ");
        numOfdice = scanner.nextInt();
        if(numOfdice<0){
            System.out.println("Must be greater than 0!!");
        }
        else{
            System.out.println("You rolled the dice");
            for(int i=0; i<numOfdice;i++){
                int roll = random.nextInt(1,7);
                System.out.println("You rolled "+roll);
                printDie(roll);
                total+=roll;
            }
            System.out.println("Total: "+total);
        }

        scanner.close();
    }

    static void printDie(int roll){
        String dice1,dice2,dice3,dice4,dice5,dice6;
        dice1="""
                 -------
                |       |
                |   ●   |
                |       |\s
                 -------
               \s""";
        dice2= """
                 -------
                | ●     |
                |       |
                |     ● |\s
                 -------
               \s""";
        dice3="""
                 -------
                | ●     |
                |   ●   |
                |     ● |
                 -------
               """;
        dice4="""
                 -------
                | ●   ● |
                |       |
                | ●   ● |
                 -------
               """;
        dice5="""
                 -------
                | ●   ● |
                |   ●   |
                | ●   ● |
                 -------
               """;
        dice6="""
                 -------
                | ●   ● |
                | ●   ● |
                | ●   ● |
                 -------
               """;

        switch (roll){
            case 1 -> System.out.println(dice1);
            case 2 -> System.out.println(dice2);
            case 3 -> System.out.println(dice3);
            case 4 -> System.out.println(dice4);
            case 5 -> System.out.println(dice5);
            case 6 -> System.out.println(dice6);
            default -> System.out.println("Invalid...");
        }
    }

    public static void phoneKeys(){
        char[] key1 = {'7','8','9'};
        char[] key2 = {'4','5','6'};
        char[] key3 = {'1','2','3'};
        char[] operands = {'*','0','#'};

        char[][] phoneNumber = {{'7','8','9'},
                {'4','5','6'},
                {'1','2','3'},
                {'*','0','#'}};
//        char[][] telkeys = {key1,key2,key3,operands};

        //for loop
        for(char[] row: phoneNumber){
            for (char num:row){
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }
}