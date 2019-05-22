package Easy;

public class easy_66 {

    public static void main(String[] args){
        int[] nums = {0};
        int[] out = plusOne(nums);
        for (int i = 0; i < out.length; i++) {
            System.out.print(out[i]);
        }
    }

    /**
     * PERFECT! 100% 100%
     * @param digits
     * @return
     */
    public static int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0 ; i--) {
            if(digits[i] + 1 != 10){
                digits[i]++;
                break;
            }
            else {
                if(i != 0){
                    digits[i] = 0;
                }
                else {
                    int[] res = new int[digits.length + 1];
                    res[0] = 1;
                    return res;
                }
            }
        }
        return digits;
    }

}
