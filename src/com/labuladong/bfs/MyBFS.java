/*
package com.labuladong.bfs;

*/
/**
 * ��һ�����������ҳ�����С��ȡ�
 * ��С����ǴӸ��ڵ㵽���Ҷ�ӽڵ�����·���ϵĽڵ�����
 *//*

public class MyBFS {

    int minDepth(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // root �������һ�㣬depth ��ʼ��Ϊ 1
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            */
/* ����ǰ�����е����нڵ���������ɢ *//*

            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                */
/* �ж��Ƿ񵽴��յ� *//*

                if (cur.left == null && cur.right == null)
                    return depth;
                */
/* �� cur �����ڽڵ������� *//*

                if (cur.left != null)
                    q.offer(cur.left);
                if (cur.right != null)
                    q.offer(cur.right);
            }
            */
/* �������Ӳ��� *//*

            depth++;
        }
        return depth;
    }


    public static void main(String[] args) {

    }

}
*/
