package Easy;

public class easy_100 {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    /**
     * 100% 100%
     * @param args
     */
    public static void main(String[] args){
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);

        System.out.println(isSameTree(root1,root2));
    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if((p == null && q!= null) || (p != null && q == null)){
            return false;
        }
        if(p == null){
            return true;
        }

        if (p.val == q.val) {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
        else {
            return false;
        }
    }
}
