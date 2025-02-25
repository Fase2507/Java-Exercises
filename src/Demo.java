public class Demo {

  public static void main(String[] args){
    int nums[]={1,3,5,7,9,11,13,14,15,16,163,1321,1322,1324,1326,1328,1329};
    int target=1321;

    int result = linearSearch(nums,target);
    int newResult=binarySearch(nums, target);
  if(newResult!=-1){
    System.out.println(" Linear; Element found at index: "+ result);
    System.out.println("Binary; Element found at index: "+ newResult);

  }else{
  System.out.println("Element not found at index");
}
  }
  public static int linearSearch(int[] nums,int target){
    int steps=0;
    for(int i=0;i<nums.length;i++){
      steps+=1;
      System.out.println("Linear steps; "+steps);

      if(nums[i]==target){
        return i;
      }else{

      }
    }
    return -1;
  }

  public static int binarySearch(int[] nums,int target){
    int left=0;
    int right = nums.length-1;
    int steps=0;
    while(left<=right){
      steps+=1;
      System.out.println("Binary steps; "+steps);
      int mid =(left+right)/2;
      if(nums[mid]==target){
        return mid;
      }
      else if(nums[mid]<target){
        left=mid+1;
      }
      else{
        right=mid-1;
      }
    }
    return -1;
  }
}