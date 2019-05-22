package Easy;

public class easy_27 {

    public static void main(String[] args){
        int[] input = {1,2};
        System.out.println(removeElement(input,1));
    }

    /**
     * PERFECT! 100% 100%
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement(int[] nums, int val) {
        if(nums.length == 0){
            return 0;
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == val){
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j] != val){
                        nums[i] = nums[j];
                        nums[j] = val;
                        res++;
                        break;
                    }
                    else {
                        if(j == nums.length - 1){
                            return res;
                        }
                    }
                }
            }
            else {
                res++;
            }
        }
        return res;
    }
}
