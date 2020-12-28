package com.hyf.leetcode.tree;

import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author huyufei on 2020/11/24
 * @Desc: TODO
 */
public class CountNodes {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public void preOrderTraverse(TreeNode treeNode) {

    }


    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null || root.right == null) {
            return 1;
        }
//        二叉树层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int count = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            count++;
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return count;
    }


    public static void main(String[] args) {
//        new CountNodes().countNodes()
    }
}
