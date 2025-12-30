package Tutorial;

import java.util.Scanner;


class Banking{

    static Scanner input = new Scanner(System.in);


    public static void main(String[] args){

        double balance=100;
        boolean isRunning = true;
        int choice;

        while (isRunning){

            System.out.println("**************");
            System.out.println("BAnking System");
            System.out.println("***************");

            System.out.println("1. Show balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.println("****************");

            System.out.println("Enter your choice (1-4)");
            choice = input.nextInt();
            switch (choice){
                case 1 -> showBalance(balance);
                case 2 -> balance+= deposit();
                case 3 -> withdraw(balance);
                case 4 -> isRunning=false;
                default -> System.out.println("INvalid choice".toUpperCase());
            }
        }
        input.close();

    }
    static void showBalance(double balance){
        System.out.printf("$%.2f \n",balance);
    }

    static double deposit(){
        System.out.println("Enter deposit amount: ");
        double amaount = input.nextDouble();
        System.out.printf("Amout: %.1f",amaount);
        if(amaount<0){
            System.out.println("Can't be less than 1");
            return 0;
        }
        else{
            return amaount;
        }
    }

    static double withdraw(double balance){
        System.out.println("Enter withdraw amount: ");
        double amount = input.nextDouble();
        if(amount<=0){
            System.out.println("Amount can't be less then 0!");
            return 0;
        }
        else if(amount>balance){
            System.out.println("You don't have enough money to withdraw that amount!!");
            return 0;
        }
        else{
            balance-=amount;
            System.out.printf("You withdrawed %.2f and your balance is %.2f",amount,balance);
            return amount;
        }

    }




}