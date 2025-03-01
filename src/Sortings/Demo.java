public class Demo {

  public static void main(String[] args){
      int nums[]={1,3,5,7,9,11,13,14,15,16,163,1321,1322,1324,1326,1328,1329,1400,1402,1405,1555};
      int target=1322;

      int result = linearSearch(nums,target);
      binarySearch(nums, target);
      if(result!=-1){
        System.out.println("Element found at index: "+ result);

      }else{
      System.out.println("Element not found at index");
      }
  }
  public static int linearSearch(int[] nums,int target){
    int steps=0;
    for(int i=0;i<nums.length;i++){
      steps+=1;

      if(nums[i]==target){
        System.out.println("Linear steps; "+steps);
        return i;
      }else{

      }
    }
    System.out.println("Linear steps; "+steps);

    return -1;
  }

  public static int binarySearch(int[] nums,int target){
    int left=0;
    int right = nums.length-1;
    int steps=0;
    while(left<=right){
      steps+=1;
      int mid =(left+right)/2;
      if(nums[mid]==target){
        System.out.println("Binary steps; "+steps);
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