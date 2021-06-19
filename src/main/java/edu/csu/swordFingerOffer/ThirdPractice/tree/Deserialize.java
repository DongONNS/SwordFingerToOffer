package edu.csu.swordFingerOffer.ThirdPractice.tree;

import edu.csu.TreeNode;

public class Deserialize {
    private String deserialize;
    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;


        String str = Serialize(treeNode1);
        System.out.println("序列化后的结果为： " + str);
        TreeNode treeNode = Deserialize(str);
    }
    // 序列化
    static String Serialize(TreeNode root) {
        if(root == null){
            return "#";
        }
        return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
    }

    // 反序列化
    static TreeNode Deserialize(String str) {
        if(str.length() == 0) return null;

        int index = str.indexOf(" ");
        String node = index == -1 ? str : str.substring(0,index);
        str = index == -1 ? "" : str.substring(index + 1);

        if(node.equals("#")) return null;

        int val = Integer.valueOf(node);
        TreeNode root = new TreeNode(val);

        root.left = Deserialize(str);
        root.right = Deserialize(str);

        return root;
    }
}
