package Easy;

public class easy_58 {

    public static void main(String[] args){
        String s = "    a";
        System.out.println(lengthOfLastWord(s));
    }

    public static int lengthOfLastWord(String s) {
        if(s.equals("")){
            return 0;
        }
        int res = 0;
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' '){
                if(res > 0){
                    return res;
                }
            }
            else {
                res++;
            }
        }
        return res;
    }
}
