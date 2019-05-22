package Easy;

public class easy_88 {


    /**
     *  100%  99.59%
     * @param args
     */
    public static void main(String[] args){
        int[] nums1 = {2,0};
        int[] nums2 = {1};
        int m = 1;
        int n = 1;
        merge(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]);
        }
    }

    /**
     * nums1.length >= n+m
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        if(n != 0){
            res = new int[nums1.length];
            flag1 = m;
            flag2 = n;
            mergeReverse(nums1,0,nums2,0,m + n,0);
            for (int i = 0; i < nums1.length; i++) {
                nums1[i] = res[i];
            }
        }
    }

    static int flag1;
    static int flag2;
    static int[] res ;

    public static int[] mergeReverse(int[] nums1,int i,int[] nums2,int j,int end,int resIndex){
        if(resIndex == end){
            return res;
        }
        if(i == flag1){
            for (int k = j; k < end - i; k++,resIndex++) {
                res[resIndex] = nums2[k];
            }
            return res;
        }
        if(j == flag2){
            for (int k = i; k < end - j; k++,resIndex++) {
                res[resIndex] = nums1[k];
            }
            return res;
        }
        if(nums1[i] <= nums2[j]){
            res[resIndex] = nums1[i];
            return mergeReverse(nums1, i + 1, nums2, j, end,resIndex + 1);
        }
        else {
            res[resIndex] = nums2[j];
            return mergeReverse(nums1, i, nums2, j+1, end,resIndex + 1);
        }
    }

}
