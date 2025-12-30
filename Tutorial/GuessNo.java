package Tutorial;

import java.util.Random;
import java.util.Scanner;

class GuessNo {
//    public static void main(String[] args) {
//
//        boolean res=false;
//        int sayac = 1;
//        while (!res){
//            res=tahminEt(9);
//            String metin = res ? "Tebrikler dogru":"Maalesef yanlis, deneme: "+sayac;
//            System.out.println(metin);
//            sayac++;
//        }
//    }
//
//    public static boolean tahminEt(int sinir){
//        Random rast = new Random();
//        int sayi = rast.nextInt(sinir);
//
//        System.out.println("Sayiyi tahmin et: ");
//        int tahmin = klavye.nextInt();
//
//        return sayi==tahmin;
//    }
//}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        int attempt = 0;
        int guess;
        int max = 100, min = 0;

        System.out.println("Guees a number");
        System.out.println("Which numbers do you choose ? ");
        System.out.print("MIN: ");
        min = scan.nextInt();
        System.out.print("MAX: ");
        max = scan.nextInt();
        int random = rand.nextInt(min, max);
        System.out.printf("Between %d-%d\n", min, max);

        do {
            System.out.println("Enter a number");
            guess = scan.nextInt();
            // ternary
            String cikti = guess == random ? "You won number is "+random+" "+ " Attempt: "+attempt:
                    (guess > random ? "high attempt: "+(attempt++) :"low attempt: "+(attempt++));
            System.out.println(cikti);
//            if (guess == random) {
//                System.out.printf("You won number is %d. Attempt: %d", random, attempt);
//            } else if (guess > random) {
//                System.out.println("HIGH");
//                attempt++;
//            } else {
//                System.out.println("LOW");
//                attempt++;
//            }
        } while (guess != random);
    }
}