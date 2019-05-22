package Easy;

public class easy_35 {

    public static void main(String[] args){
        int[] nums = {2,7,8,9,10};
        System.out.println(searchInsert(nums,9));
    }

    /**
     * 查找target位置，如果找不到，就返回target应该在的位置
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        return binarySearch(nums,target,nums.length/2,nums.length);
    }

    public static int binarySearch(int[] nums,int target,int index,int end){
        int compare = nums[index];
        if(compare == target){
            return index;
        }
        else if(compare > target){
            if(index/2 == index){
                return 0;
            }
            if(nums[index - 1] < target){
                return index;
            }
            return binarySearch(nums,target,index/2,index);
        }
        else{
            if((index+nums.length)/2 == index){
                return index+1;
            }
            if(nums[index + 1] > target){
                return index + 1;
            }
            return binarySearch(nums,target,(index + end)/2,end);
        }
    }

}
