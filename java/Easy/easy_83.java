package Easy;

import java.util.HashSet;

public class easy_83 {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(4);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(4);
        l1.next.next.next = new ListNode(4);
        ListNode out = deleteDuplicates(l1);
        while (out != null){
            System.out.print(out.val);
            out = out.next;
        }
    }

    /**
     * leetcode discussion 利用了sorted的特性，只需要对当前节点和下一个节点做唯一性验证就可以
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates(ListNode head){
        if(head == null)
            return null;
        ListNode res = head;
        while(head.next != null){
            if(head.val == head.next.val){
                head.next = head.next.next;
            }
            else {
                head = head.next;
            }
        }
        return res;
    }

    /**
     * 没有用到sorted的特性！又没有好好审题啦！多了hashset的存放和查询的操作和空间
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates0(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode temp = head;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(head.val);
        while (temp.next != null){
            if(hashSet.contains(temp.next.val)){
                if(temp.next.next != null){
                    temp.next = temp.next.next;
                }
                else {
                    temp.next = null;
                }
            }
            else {
                hashSet.add(temp.next.val);
                temp = temp.next;
            }
        }
        return head;
    }

}
