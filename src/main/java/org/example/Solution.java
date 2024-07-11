package org.example;

public class Solution {
    public class TreeNode {
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

    public int pathSum(TreeNode root, int targetSum) {
        int[] result = new int[1];
        top(root, targetSum, result);
        return result[0];
    }

    public void top(TreeNode root, int targetSum, int[] result) {
        if (root == null) {
            return;
        }
        bottom(root, targetSum, 0, result);
        top(root.left, targetSum, result);
        top(root.right, targetSum, result);
    }

    public void bottom(TreeNode root, int targetSum, long sum, int[] result) {
        if (root == null) {
            return;
        }
        sum += root.val;
        if (sum == targetSum) {
            result[0]++;
        }
        bottom(root.left, targetSum, sum, result);
        bottom(root.right, targetSum, sum, result);
    }
}
