package Tutorial;
import java.util.Scanner;
class MeasurementConverter {
    public static void main(String[] arguments){
        Scanner input = new Scanner(System.in);
        double weight;
        double neWeight;
        int choice;
        double temp;
        double newTempt;
        String unit;

        System.out.println("Welcome to weight and temperature converter");
        System.out.println("1.Convert lbs to kg ");
        System.out.println("2.Convert kg to lbs");
        System.out.println("3.Convert Fahrenheit/Celsius");
        System.out.println("4. Calculation");

        System.out.println("Choose your choice: ");
        choice = input.nextInt();
        //if statement
        if(choice == 1){
            System.out.println("Enter the weight in lbs");
            weight = input.nextDouble();
            neWeight = weight*0.453592;
            System.out.printf("Your weight is: %.2f", neWeight);
        }
        else if(choice == 2){
            System.out.println("Enter the weight in kg");
            weight = input.nextDouble();
            neWeight = weight*2.20462;
            System.out.printf("Your weight is: %.2f", neWeight);
        }
        else if(choice == 3){
            System.out.println("Enter the temperature");
            temp = input.nextDouble();
            System.out.println("Celsius or Fahrenheit (C or F)");
            unit = input.next().toUpperCase();

            newTempt = (unit.equals("C")) ? (temp-32) * 5/9: (temp * 5/9) + 32;
            System.out.printf("Temperature is %.2f°%s" ,newTempt,unit);
        }
        else if(choice==4){
            MeasurementConverter calc = new MeasurementConverter();
            calc.Calculator();
        }
        else{
            System.out.println("Not a valid option");
        }
        input.close();
    }
     public  void Calculator(){
        Scanner scn = new Scanner(System.in);

        double num1,num2;
        char operator;
        double result=0;
        boolean isValid=true;
        System.out.println("Enter the first number: ");
        num1 = scn.nextDouble();
        System.out.println("Enter the second number: ");
        num2 = scn.nextDouble();
        System.out.println("Enter the type of process (+,-,/,*,^) : ");
        operator = scn.next().charAt(0);

        switch(operator){
            case '+' -> result = num1+num2;
            case '-' -> result = num1-num2;
            case '/' -> {
                if (num2==0){
                    System.out.println("Cannot divide by 0!!");
                    isValid=false;
                }else
                    result = num1/num2;
            }
            case '*' -> result = num1 * num2;
            case '^' -> result = Math.pow(num1,num2);
            default -> {
                System.out.println("Invalid operator symbol!");
                isValid=false;
            }
        }
        if (isValid)
            System.out.println(result);
    }
}