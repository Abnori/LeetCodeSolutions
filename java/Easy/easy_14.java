package Easy;

public class easy_14 {
//    Write a function to find the longest common prefix string amongst an array of strings.
//    If there is no common prefix, return an empty string "".
//    Example 1:
//    Input: ["flower","flow","flight"]
//    Output: "fl"
//    Example 2:
//    Input: ["dog","racecar","car"]
//    Output: ""
//    Explanation: There is no common prefix among the input strings.
//            Note:
//    All given inputs are in lowercase letters a-z.

    public static void main(String[] args){
        String[] strs = {"aaa","baa"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if(strs.length == 0){
            return "";
        }
        if(strs.length == 1){
            return strs[0];
        }
        String res = strs[0];
        int compare_length = res.length();//允许两个字符串比较的最大长度
        int count = compare_length;//这个+1要注意

        //遍历从1到strs.length-1
        for(int i = 1;i < strs.length;i++){
            int len = strs[i].length();
            //减小允许两个字符串比较的最大长度
            if(compare_length > len){
                //如果存在""直接返回""
                if(len == 0){
                    return "";
                }
                compare_length = len;
            }
            //比较char,用temp_count暂存子串长度
            int temp_count = -1;
            for (int j = 0; j < compare_length; j++) {
                if(res.charAt(j) == strs[i].charAt(j)){
                    temp_count++;
                }
                //一定要break,否则便是计算存在的相同字符数,如{"abc","lao"}会导致temp_count为1
                else{
                    break;
                }
            }
            //取最小值
            if(temp_count < count){
                count = temp_count;
            }
        }
        //如果存在
        if(count != -1){
            return res.substring(0,count + 1);//+1,因为temp_count是从-1开始计算
        }
        else{
            return "";
        }

    }

}
