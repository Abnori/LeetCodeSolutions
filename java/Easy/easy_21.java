package Easy;

import java.util.ArrayList;

public class easy_21 {

      public static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode out = mergeTwoLists(l1,l2);
        while (out != null){
            System.out.print(out.val);
            out = out.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode head = new ListNode(0);
        ListNode merged = head;//head的引用类型
        while (l1 != null && l2 != null){
            if(l1.val <= l2.val){
                merged.next = l1;
                l1 = l1.next;
                merged = merged.next;
            }
            else {
                merged.next = l2;
                l2 = l2.next;
                merged = merged.next;
            }
        }
        if(l1 != null){
            merged.next = l1;
        }
        if(l2 != null){
            merged.next = l2;
        }
        return head.next;
    }

    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {//真的非常低效，34ms，没有用到sorted的特性，适合一般的场景
        ArrayList<Integer> integers = new ArrayList<>();
        if(l1 == null && l2 == null){
            return null;
        }
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        while (l1 != null){
            integers.add(l1.val);
            l1 = l1.next;
        }
        while (l2 != null){
            integers.add(l2.val);
            l2 = l2.next;
        }
        integers.sort(Integer::compareTo);
        ArrayList<ListNode> listNodes = new ArrayList<>();
        for (int i = 0; i < integers.size(); i++) {
            ListNode temp = new ListNode(integers.get(i));
            listNodes.add(temp);
        }
        for (int i = 0; i < listNodes.size() -1; i++) {
            addNode(listNodes.get(i),listNodes.get(i+1));
        }
        return listNodes.get(0);
    }
    public static ListNode addNode(ListNode l,ListNode listNode){
          ListNode res = l;
          res.next = listNode;
          return res;
    }

}
