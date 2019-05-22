package Easy;

import java.util.Stack;
//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//        An input string is valid if:
//        Open brackets must be closed by the same type of brackets.
//        Open brackets must be closed in the correct order.
//        Note that an empty string is also considered valid.
public class easy_20 {
    public static void main(String[] args){
        String input = "([{)(}])";
        System.out.println(isValid1(input));//使用栈+优先级判定
        System.out.println(isValid2(input));//使用栈，O(n)解决！注意判断((这样的情况
    }
    public static boolean isValid2(String s){
        if(s.length() == 0){
            return true;
        }
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> characters = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '('){
                characters.push(')');
            }
            else if(s.charAt(i) == '['){
                characters.push(']');
            }
            else if(s.charAt(i) == '{'){
                characters.push('}');
            }
            else {
                if(characters.isEmpty() || characters.pop() != s.charAt(i)){
                    return false;
                }
            }
        }
        return characters.isEmpty();
    }

    public static boolean isValid1(String s) {
        if(s.length() == 0){
            return true;
        }
        if(s.length() % 2 != 0){
            return false;
        }
        Boolean res = true;
        Stack<Integer> integers = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if(integers.isEmpty()){
                if(getPriority(s.charAt(i)) < 3 ){
                    integers.push(getPriority(s.charAt(i)));
                    continue;
                }
                else{
                    return false;
                }
            }
            Integer top = integers.peek();
            int prio_now = getPriority(s.charAt(i));
            int minus = prio_now - top.intValue();
            if(minus != 3){// ==3为符合
                if(prio_now >= 3){
                    return false;
                }
                else {
                    integers.push(Integer.valueOf(prio_now));
                }
            }
            else {
                integers.pop();
            }
        }
        if(!integers.isEmpty()){
            return false;
        }
        return res;
    }

    public static int getPriority(char c){
        switch (c){
            case '(':
                return 0;
            case ')':
                return 3;
            case '[':
                return 1;
            case ']':
                return 4;
            case '{':
                return 2;
            case '}':
                return 5;
            default:
                return -1;
        }
    }

}
