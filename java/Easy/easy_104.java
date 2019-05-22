package Easy;

public class easy_104 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    /**
     * 最大深度遍历  100% 89.37%
     * @param args
     */
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(9);
        root.left.left = new TreeNode(10);
        root.left.left.left = new TreeNode(99);
        root.left.left.left.right = new TreeNode(88);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxDepth(root));
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        else if(root.left == null){
            return count(root.right,2);
        }
        else if(root.right == null){
            return  count(root.left,2);
        }
        else {
            int leftMaxDepth = count(root.left,2);
            int rightMaxDepth = count(root.right, 2);
            return Math.max(leftMaxDepth,rightMaxDepth);
        }
    }

    public static int count(TreeNode root,int count){
        if(root.left == null && root.right == null){
            return count;
        }
        if(root.left != null && root.right == null){
            int temp = count + 1;
            return count(root.left, temp);
        }
        if( root.left == null){
            int temp = count + 1;
            return count(root.right, temp);
        }
        int temp = count + 1;
        int leftMaxDepth = count(root.left,temp);
        int rightMaxDepth = count(root.right,temp);
        return Math.max(leftMaxDepth,rightMaxDepth);

    }
}
