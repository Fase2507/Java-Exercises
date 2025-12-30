package Tutorial;

import java.util.Scanner;

class LoginControl{
   static Scanner keyboard = new Scanner(System.in);
   public static void main(String[] args) {
        String mail = "aaa@gmail.com";
        String pass = "1234";

        System.out.println("Enter username: ");
        String user_mail = keyboard.nextLine();
        System.out.println("Enter password: ");
        String user_pass = keyboard.nextLine();

        boolean isMail = user_mail.equals(mail);
        boolean isPass = user_pass.equals(pass);
        String result =  isMail ? (isPass ? "basarili giris.":"sfire yanlis"):"yanlis kullanici adi";
        System.out.printf("Sonuc: %s",result);
//        if(user_mail.equals(mail)){
//            if(user_pass.equals(pass))
//                System.out.println("Giris basarili!");
//            else
//                System.out.println("Sifre yanlis");
//        }
//        else{
//            System.out.println("Mail adresi yanlis!!");
//        }

    }
}