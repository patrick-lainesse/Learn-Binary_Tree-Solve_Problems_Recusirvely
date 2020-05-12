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

    // Bottom-down solution
    public static void maxDepth(TreeNode root, int depth) {

        if(depth == 0) answer = 0;
        if(root == null) return;

        if(root.left == null && root.right == null) {
            answer = Math.max(answer, depth);
        }
        maxDepth(root.left, depth + 1);
        maxDepth(root.right, depth + 1);
    }

    static Queue<Integer> leftQueue = new LinkedList<>();
    static Queue<Integer> rightQueue = new LinkedList<>();
    static HashMap<Integer, Integer> leftHash = new HashMap<>();
    static HashMap<Integer, Integer> rightHash = new HashMap<>();

    private static HashMap<Integer, Integer> leftChild(TreeNode root) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(root.left.val, root.right.val);
        System.out.println("Hash left: " + hash);
        return hash;
    }
    private static HashMap<Integer, Integer> rightChild(TreeNode root) {

        HashMap<Integer, Integer> hash = new HashMap<>();
        hash.put(root.right.val, root.left.val);
        System.out.println("Hash right: " + hash);
        return hash;
    }
    // recursive solution
    public static boolean isSymmetric(TreeNode root) {

        if(root == null) return false;

        while (leftChild(root).equals(rightChild(root))) {
            System.out.println(root.val);
            isSymmetric(root.left);
            isSymmetric(root.right);
        }

        System.out.println("End recursion");

        return true;
    }

    public static void main(String[] args) {

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

        TreeNode treeNodeF = new TreeNode(6, treeNodeB, treeNodeG);

        //System.out.println(maxDepth(treeNodeF);
        maxDepth(treeNodeF, 0);
        System.out.println(answer);

        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode15 = new TreeNode(15);

        TreeNode treeNode20 = new TreeNode(20, treeNode15, treeNode7);
        TreeNode treeNode9 = new TreeNode(9);

        TreeNode treeNode3 = new TreeNode(3, treeNode9, treeNode20);
        //System.out.println(maxDepth(treeNode3);
        maxDepth(treeNode3, 0);
        System.out.println(answer);
        //System.out.println(maxDepth(new TreeNode()));
        maxDepth(new TreeNode(), 0);
        System.out.println(answer);
        //System.out.println(maxDepth(null));
        maxDepth(null, 0);
        System.out.println(answer);*/

        // Is symmetric
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);

        TreeNode treeNode2a = new TreeNode(2, treeNode3, treeNode4);
        TreeNode treeNode2b = new TreeNode(2, treeNode4, treeNode3);
        TreeNode treeNode1 = new TreeNode(1, treeNode2a, treeNode2b);
        System.out.println(isSymmetric(treeNode1));     // expected: true

        /*TreeNode treeNode2c = new TreeNode(2, null, treeNode3);
        TreeNode treeNode1b = new TreeNode(1, treeNode2c, treeNode2c);
        System.out.println(isSymmetric(treeNode1));     // expected: false*/
    }
}
