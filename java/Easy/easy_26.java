package Easy;

public class easy_26 {

    public static void main(String[] args){
        int[] input = {1,1,2,2,3,3,4,4,5};
        System.out.println(removeDuplicates(input));
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return 1;
        }
        int compare = nums[0];
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] != compare){
                nums[res] = nums[i];
                compare = nums[i];
                res++;
            }
        }
        return res;
    }
}
