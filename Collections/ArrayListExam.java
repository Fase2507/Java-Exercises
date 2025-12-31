package Collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;

class ArrayListExam{

    public static void main(String[] args){
        ArrayList<Double> liste = new ArrayList<>();
        Random random = new Random();
        for(int i =0;i<5;i++){
            liste.add((double) Math.round(random.nextDouble(1,100)));
        }
        Comparator<Double> numericKarsilastirici = new Comparator<Double>() {
            @Override
            public int compare(Double o1, Double o2) {
                if(o1>o2) return 1;
                else if(o1<o2) return -1;
                else return 0;
            }
        };
        Double[] dizi = new Double[liste.size()];
        for(int i=0; i<liste.size();i++){
            dizi[i] = liste.get(i);
        }
        
        liste.sort(numericKarsilastirici);
        System.out.println(liste);
    }

















    public static ArrayList<Integer> tersiniBul(ArrayList<Integer> listem){
        ArrayList<Integer> newListem = new ArrayList<>();
        for(int i=listem.size()-1;i>=0;i--){
            newListem.add(listem.get(i));
        }
        return newListem;
    }

    // Listeleri birlestir
    public static ArrayList<Integer> listeleriBirlestir(ArrayList<Integer> liste1, ArrayList<Integer> liste2){
        ArrayList<Integer> birlesmis ;
        birlesmis = new ArrayList<>();

//        for(Integer el:liste1){
//            birlesmis.add(el);
//        }
//        for(Integer el:liste2){
//            birlesmis.add(el);
//        }
        birlesmis.addAll(liste1);
        birlesmis.addAll(liste2);
        return birlesmis;
    }

}