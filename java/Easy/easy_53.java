package Easy;

public class easy_53 {

    public static void main(String[] args){
        int[] nums = {-2,-1,-3,4,-1,-2,-1,-5,-4};
//        int[] nums1 = {1,2,3,4,5,6};
        System.out.println(maxSubArray(nums));
    }

    /**
     * O(n^2)
     * 贪心解决，但是不够精炼，存在两个嵌套，并且在nums全非负的时候表现不佳
     * @param nums
     * @return
     */
    public static int maxSubArray0(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            res = temp > res ? temp : res;//每次都有机会比较！
            if(nums[i] >= 0){
                int loss = 0;
                for (int j = i+1; j < nums.length; j++) {
                    if(nums[j] >= 0){
                        temp += nums[j];
                    }
                    else{
                        loss += nums[j];
                    }
                    if(temp + loss < 0){//temp为负数必然不ok
                        break;
                    }
                    else {
                        temp += loss;
                        loss = 0;
                        res = temp > res ? temp : res;//每次temp非负都有机会比较
                    }
                }
            }
        }
        return res;
    }

    /**
     * O(n)
     * leetcode 上别人写的贪心算法，是真的棒！
     * 这个题的思路是，我每次都有机会用temp值与我的Max值做一次比较（无论temp是正是负）。比较前，如果temp值小于零，直接由nums[i]替换，如果大于零，就加上nums[i]
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int temp = nums[0],max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(temp < 0){
                temp = nums[i];
            }
            else {
                temp += nums[i];
            }
            max = temp > max ? temp : max;
        }
        return max;
    }


}
