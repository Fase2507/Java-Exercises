public class Bubble {

  public static void main(String[] args){
    int nums[]={6,5,7,8,2,3,4};
    int size=nums.length;
    int temp=0;
    System.out.println("Before sorting ");
    for(int num: nums){
      System.out.println(num+" ");
    }
    for(int i=0;i<size;i++){
      for(int j=0; j<size-i-1;j++){
        if(nums[j]<nums[j+1])

        {
          temp=nums[j];
          nums[j]=nums[j+1];
          nums[j+1]=temp;
        }
        System.out.println();
        for(int num: nums){
          System.out.println(num+" ");
        }  
      }
      
    }

    // System.out.println("Steps"+ step);
    System.out.println("after sorting");
    for(int num: nums){
      System.out.println(num+" ");
    }

  }
}