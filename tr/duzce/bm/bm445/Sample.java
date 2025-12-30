package tr.duzce.bm.bm445;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Sample implements DBhelper{


    public String getFullUrl(){

//        StringBuilder sb = new StringBuilder();
//        sb.append(url).append(":").append(port);
        return DB_URL+":"+DB_PORT;
    }
    public static void main(String[] d) {
        Scanner scn = new Scanner(System.in);
        ArrayList<String> foods = new ArrayList<>();

        System.out.println("Enter the number of food you like");
        int numOfood = scn.nextInt();
        scn.nextLine();
        for(int i=1;i<=numOfood;i++){
            System.out.println("number #"+i+" food");
            String food = scn.nextLine();
            foods.add(food);
        }
        Collections.sort(foods);
        System.out.println(foods);
        scn.close();
    }
}