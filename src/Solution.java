import java.util.*;

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

    // Bottom-up solution
    /*public static int maxDepth(TreeNode root) {

        if(root == null) return 0;

            int lDepth = maxDepth(root.left);
            int rDepth = maxDepth(root.right);

            return Math.max(lDepth, rDepth) + 1;
    }*/

    static int answer = 0;

    // top-down solution
    public static void maxDepth(TreeNode root, int depth) {

        if(depth == 0) answer = 0;
        if(root == null) return;

        if(root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }

    // https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/536/
    public static boolean isSymmetric(TreeNode root) {

        return isMirror(root, root);
    }

    private static boolean isMirror(TreeNode left, TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        return (left.val == right.val)
                && isMirror(left.right, right.left)
                && isMirror(left.left, right.right);
    }

    //https://leetcode.com/explore/learn/card/data-structure-tree/17/solve-problems-recursively/537/
    // using a top-down solution to pass parameters
    public static boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {

        // Path Sum
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1);

        TreeNode treeNode11 = new TreeNode(11, treeNode7, treeNode2);
        TreeNode treeNode13 = new TreeNode(13);
        TreeNode treeNode4b = new TreeNode(4, null, treeNode1);

        TreeNode treeNode4a = new TreeNode(4, treeNode11, null);
        TreeNode treeNode8 = new TreeNode(8, treeNode13, treeNode4b);
        TreeNode treeNode5 = new TreeNode(5, treeNode4a, treeNode8);

        System.out.println(hasPathSum(treeNode5, 22)); // expected: true
        System.out.println(hasPathSum(treeNode1, 0)); // expected: false

        // Is symmetric
        /*TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2a = new TreeNode(2, treeNode3, treeNode4);
        TreeNode treeNode2b = new TreeNode(2, treeNode4, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2a, treeNode2b);
        System.out.println(isSymmetric(treeNode1));     // expected: true

        TreeNode treeNode2c = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1b = new TreeNode(1, treeNode2c, treeNode2c);
        System.out.println(isSymmetric(treeNode1b));     // expected: false*/

        // Max Depth
        /*TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode2 = new TreeNode(2, treeNode3, null);
        TreeNode treeNode1 = new TreeNode(1, null, treeNode2);
        System.out.println(maxDepth(treeNode1));*/

        /*TreeNode treeNodeC = new TreeNode(3);
        TreeNode treeNodeE = new TreeNode(5);
        TreeNode treeNodeH = new TreeNode(8);

        TreeNode treeNodeA = new TreeNode(1);
        TreeNode treeNodeD = new TreeNode(4, treeNodeC,treeNodeE);
        TreeNode treeNodeI = new TreeNode(9, treeNodeH, null);

        TreeNode treeNodeB = new TreeNode(2, treeNodeA, treeNodeD);
        TreeNode treeNodeG = new TreeNode(7, null, treeNodeI);

        TreeNode treeNodeF = new TreeNode(6, treeNodeB, treeNodeG); */
    }
}
