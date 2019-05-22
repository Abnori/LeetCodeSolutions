package Easy;

public class easy_67 {

    public static void main(String[] args){
        String a = "1";
        String b = "111";
        System.out.println(addBinary(a,b));

    }

    public static String addBinary(String a, String b) {
        if(a.length() > b.length()){
           return calculate(a,b);
        }
        else {
            return calculate(b,a);
        }
    }

    /**
     * a is longer , b is shorter
     * @param a
     * @param b
     * @return
     */
    public static String calculate(String a,String b){
        boolean ifCarry = false;
        StringBuilder res = new StringBuilder("");
        for (int i = b.length()-1; i >= 0 ; i--) {
            boolean flag1 = b.charAt(i) == '1';
            boolean flag2 = a.charAt(i+a.length()-b.length()) == '1';

            if(flag1 && flag2 && ifCarry){
                ifCarry = true;
                res.insert(0,"1");
            }
            else if(!flag1 && !flag2 && !ifCarry) {
                ifCarry = false;
                res.insert(0,"0");
            }
            else if((flag1 && !flag2 && !ifCarry) || (!flag1 && flag2 && !ifCarry) || (!flag1 && !flag2)){
                ifCarry = false;
                res.insert(0,"1");
            }
            else {
                ifCarry = true;
                res.insert(0,"0");
            }
        }
        for (int i = a.length() - b.length() -1; i >= 0 ; i--) {
            if(a.charAt(i) == '1' && ifCarry){
                ifCarry = true;
                res.insert(0,"0");
            }
            else if(a.charAt(i) == '1'|| ifCarry ){
                ifCarry = false;
                res.insert(0,"1");
            }
            else {
                ifCarry = false;
                res.insert(0,a.charAt(i));
            }
        }
        if(ifCarry){
            res.insert(0,"1");
        }
        return res.toString();
    }

}
