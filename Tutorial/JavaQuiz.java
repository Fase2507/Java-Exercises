package Tutorial;

import java.util.Scanner;

//Java Quiz Game
 //Options Array[][] DONE
 //Declare Variables DONE
 //Welcome msg DONE
 //Question Loops
    //Options DONE
    // Get guess from user DONE
    // Check the answer DONE
    // Display the score DONE
class JavaQuiz{
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {

        //Array
        String[] question ={"What is the main function of router",
                            "What is the brain of computer",
                            "What year was Facebook launched",
                            "What was the first programming language"};

        String[][] options = {{"1.Storin data","2.Encrypting data","3. Direting the internet traffic"},
                              {"1. CPU","2. SSD"},
                              {"1. 1999","2. 2004"},
                              {"1. C","2. Fortran"}};

        int[] answers = {3,1,2,2};
        int T = 0;
        int F = 0;
        String result=null;
        System.out.println("Welcome to JQG !!!");

        for(int i=0; i<question.length;i++){
            System.out.println(question[i]);
            for(int j=0;j< options[i].length;j++){
                System.out.print(options[i][j]+" ");
            }
            System.out.println();
            int guess = keyboard.nextInt();

            result = (guess==answers[i]) ? ("True "+ (++T)) : ("False "+ (++F));
//            if(guess==answers[i]){
//                System.out.println("True ");
//                T += 1;
//            }
//            else{
//                System.out.println("False");
//                F += 1;
//            }

        }
//        System.out.println("Result is "+(T)+" true "+(F)+ " false ");

        System.out.println(result);
        keyboard.close();
    }


}