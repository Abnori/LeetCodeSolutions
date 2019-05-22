package Easy;

public class easy_70 {
//    You are climbing a stair case. It takes n steps to reach to the top.
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//    Note: Given n will be a positive integer
// ex: 2,2    3,3

    public static void main(String[] args){
        System.out.println(climbStairs(4));
    }

    public static int climbStairs(int n) {
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int n1 = 1;
        int n2 = 2;
        int res = 0;
        for (int i = 0; i < n - 2; i++) {
            res = n1 + n2;
            n1 = n2;
            n2 = res;
        }
        return res;
    }


}
