package Easy;

public class easy_101 {

    /**
     * 判断是否为对称树  100% 99.88%
     */
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(2);
        root.right.right = new TreeNode(2);
        System.out.println(isSymmetric(root));
    }

    public static boolean isSymmetric(TreeNode root) {
        if((root == null)||(root.left == null && root.right == null)){
            return true;
        }
        if((root.left == null ) || (  root.right == null)){
            return false;
        }
        if(root.left.val != root.right.val){
            return false;
        }
        else {
            return isSame(root.left,root.right);
        }
    }

    public static boolean isSame(TreeNode left,TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if((left != null && right == null) || left == null){
            return false;
        }
        if(left.val == right.val){
            return isSame(left.left,right.right)&&isSame(left.right,right.left);
        }
        else {
            return false;
        }
    }

}
