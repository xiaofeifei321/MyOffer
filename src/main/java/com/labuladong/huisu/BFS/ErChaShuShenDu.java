package com.labuladong.huisu.BFS;


import java.util.LinkedList;
import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    /**
     * ����������С���
     */
    public class ErChaShuShenDu {
        public int minDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            Queue<TreeNode> q = new LinkedList<>();//�������ݽṹ
            q.offer(root);//�����������
            int step = 1;//��¼��ɢ�Ĳ���
            while (!q.isEmpty()) {
                int sz = q.size();
                //��ǰ�ڵ���������ɢ
                for (int i = 0; i < sz; i++) {
                    TreeNode cur = q.poll();
                    //�ж��Ƿ񵽴��յ�
                    if (cur.left == null && cur.right == null) {
                        return step;
                    }
                    if (cur.left != null) {
                        q.offer(cur.left);
                    }

                    if (cur.right != null) {
                        q.offer(cur.right);
                    }
                }
                step++;
            }
            return step;
        }
    }

    public static void main(String[] args) {
        Queue q = new LinkedList<>();//�������ݽṹ
        System.out.println(q.offer(666));
        System.out.println(q.size());
        System.out.println(q.poll());
        System.out.println(q.size());
    }

}
