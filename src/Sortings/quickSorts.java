public class quickSorts {
  public static void quickSort(int[] arr,int low,int high){
    if(low<high){
      int piv=partition(arr, low, high);

      quickSort(arr, low, piv-1);
      quickSort(arr, piv+1, high);
    }
  }
  private static int partition(int[] arr,int low,int high){
    int pivot=arr[high];
    int i=low-1;

    for(int j=low;j<high;j++){
      if(arr[j]<pivot){
        i++;
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }
    }
    
    int temp=arr[i+1];
    arr[i+1]=arr[high];
    arr[high]=temp;

    return i+1;
  }

  
  public static void main(String[] args){
    int arr[]={2,4,1,3,6,13,9};

    quickSort(arr, 0,arr.length-1);
    for(int num: arr){
      System.out.println(num+" ");
    }

  }
}