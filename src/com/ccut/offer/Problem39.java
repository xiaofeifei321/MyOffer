package com.ccut.offer;

import com.ccut.util.BinaryTreeNode;
import com.ccut.util.Tuple;
/**
 * 二叉树的深度 
 */
public class Problem39 {
	 //----递归求二叉树深度----
    public static int treeDepth(BinaryTreeNode root){
        if(root == null){
            return 0;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        return (left>right)?(left+1):(right+1);
    }

    /**
     * 判断是否为平衡二叉树
     * @param args
     */
    public static boolean isBalanced_1(BinaryTreeNode root){
        if(root==null){
            return true;
        }
        int left = treeDepth(root.left);
        int right = treeDepth(root.right);
        int diff = left - right;
        if(diff>1||diff<-1){
            return false;
        }
        return isBalanced_1(root.left)&&isBalanced_1(root.right);
    }
    
    
  //----判断平衡二叉树，每个结点只遍历一次----
    private static Tuple isBalanced(BinaryTreeNode root){
        if(root==null){
            Tuple tuple = new Tuple();
            tuple.setIsBalanced(true);
            tuple.setDepth(0);
            return tuple;
        }
        Tuple left =  isBalanced(root.left);
        Tuple right = isBalanced(root.right);
        
        if(left.getIsBalanced()&&right.getIsBalanced()){
            int diff = left.getDepth()-right.getDepth();
            if(diff<=1&&diff>=-1){
                return new Tuple(true,(left.getDepth()>right.getDepth()?left.getDepth():right.getDepth()) + 1 );
            }
        }
        return  new Tuple(false,-1);
    }
    public static boolean isBalancedBinaryTree(BinaryTreeNode root){
        Tuple tuple =  isBalanced(root);
        return tuple.getIsBalanced();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BinaryTreeNode node1 = new BinaryTreeNode();
        BinaryTreeNode node2 = new BinaryTreeNode();
        BinaryTreeNode node3 = new BinaryTreeNode();
        BinaryTreeNode node4 = new BinaryTreeNode();
        BinaryTreeNode node5 = new BinaryTreeNode();
        BinaryTreeNode node6 = new BinaryTreeNode();
        BinaryTreeNode node7 = new BinaryTreeNode();
        node1.data = 1;
        node2.data = 2;
        node3.data = 3;
        node4.data = 4;
        node5.data = 5;
        node6.data = 6;
        node7.data = 7;
        
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node3.right = node6;
        System.out.println("递归求二叉树深度： "+treeDepth(node1));
        System.out.println("是否为平衡二叉树"+isBalanced_1(node1));
        System.out.println("是否为平衡二叉树"+isBalancedBinaryTree(node1));
    }
}