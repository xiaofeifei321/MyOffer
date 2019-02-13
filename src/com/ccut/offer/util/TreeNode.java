package com.ccut.offer.util;

public class TreeNode {
      public int val = 0;
     public TreeNode left = null;
    public  TreeNode right = null;

    public TreeNode(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return "TreeNode [val=" + val + ", left=" + left + ", right=" + right
                + "]";
    }
}