package Easy;

public class easy_28 {

    public static void main(String[] args){
        String haystack = "asasasass";
        String needle = "ss";
        System.out.println(strStr(haystack,needle));
    }

    public static int strStr(String haystack, String needle) {
        if(needle.equals("")){//leetcode平台 == 是错的！说明它string用的不是常量池，而是对象实例
            return 0;
        }
        if(haystack.length() < needle.length()){
            return -1;
        }
        for (int i = 0; i < haystack.length() - needle.length() + 1;i++) {
            if(haystack.charAt(i) == needle.charAt(0)){
                int j = i + 1;
                for (; j < i + needle.length(); j++) {
                    if(haystack.charAt(j) != needle.charAt(j-i)){
                        break;
                    }
                }
                if(j == i + needle.length()){
                    return i;
                }
            }
        }
        return -1;
    }
}
