public class Solution {

    //Definition for a binary tree node.
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static int maxDepth(TreeNode root) {

        if(root == null) return 0;

            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            return Math.max(lDepth, rDepth) + 1;
    }

    public static void main(String[] args) {

        /*TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        System.out.println(maxDepth(treeNode1));*/

        TreeNode treeNodeC = new TreeNode(3);
        TreeNode treeNodeE = new TreeNode(5);
        TreeNode treeNodeH = new TreeNode(8);

        TreeNode treeNodeA = new TreeNode(1);
        TreeNode treeNodeD = new TreeNode(4, treeNodeC,treeNodeE);
        TreeNode treeNodeI = new TreeNode(9, treeNodeH, null);

        TreeNode treeNodeB = new TreeNode(2, treeNodeA, treeNodeD);
        TreeNode treeNodeG = new TreeNode(7, null, treeNodeI);

        TreeNode treeNodeF = new TreeNode(6, treeNodeB, treeNodeG);

        System.out.println(maxDepth(treeNodeF));

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode15 = new TreeNode(15);

        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);

        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        System.out.println(maxDepth(treeNode3));
        System.out.println(maxDepth(new TreeNode()));
        System.out.println(maxDepth(null));
    }
}
