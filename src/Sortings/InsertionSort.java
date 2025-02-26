public class InsertionSort {

  public static void main(String[] args){
    int arr[]={20,12,2,7,4,5};
    for(int i=1;i<arr.length;i++){
      int key=arr[i];
      int j=i-1;

      while(j>=0 && arr[j]>key){
        arr[j+1]=arr[j];
        j--;
      }
      arr[j+1]=key;
      for (int num: arr){
        System.out.println(num+" ");
      } 
      System.out.println();
    }
    for (int num: arr){
      System.out.println(num+" ");
    }
  }
}

//first we code array - and we do for loop - i and j- we will compare variables in array=template 