package com.ccut.util;

public class Tuple {
    public boolean isBalanced;
    public int depth;

    public Tuple() {
    }

    public Tuple(boolean isBalanced, int depth) {
        super();
        this.isBalanced = isBalanced;
        this.depth = depth;
    }

    // -----isBalanced,Getters and Setters----
    public boolean getIsBalanced() {
        return isBalanced;
    }

    public void setIsBalanced(boolean isBalanced) {
        this.isBalanced = isBalanced;
    }

    // -----depth,Getters and Setters----
    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

}