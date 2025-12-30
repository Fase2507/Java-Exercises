import java.util.Scanner;

class MadLib{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the adjective");
        String adj = scanner.nextLine();

        System.out.println("Enter the noun");
        String noun = scanner.nextLine();

        System.out.println("Enter the verb");
        String verb = scanner.nextLine();

        System.out.println("Today I went to school and I saw "+ noun);
        System.out.println(noun+" was "+adj+" and smiling to me");
        System.out.println("Unfortunatly my dad "+verb+"ed it!");
        scanner.close();
    }
}