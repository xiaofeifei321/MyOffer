package com.labuladong.huisu.BFS;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/**
 * ����ƴͼ����
 * LeedCode ����ƴͼ����
 * ��һ�� 2 x 3 �İ��ϣ�board���� 5 ��ש�ߣ������� 1~5 ����ʾ, �Լ�һ���ȱ�� 0 ����ʾ.
 * һ���ƶ�����Ϊѡ�� 0 ��һ�����ڵ����֣��������ң����н���.
 * ���յ��� board �Ľ���� [[1,2,3],[4,5,0]] �հ屻�⿪
 * <p>
 * ʾ��
 * ���룺board = [[1,2,3],[4,0,5]]
 * �����1
 * ���ͣ����� 0 �� 5 ��1 �����
 */
public class HuaDongPingTu {
    int[][] exchangeArray = new int[][]{
            {1, 3},
            {0, 2, 4},
            {1, 5},
            {0, 4},
            {1, 3, 5},
            {2, 4}
    };

    // �����ַ�
    public String exchangeString(String string, int src, int dis) {
        char[] chars = string.toCharArray();
        char temp = chars[dis];
        chars[dis] = chars[src];
        chars[src] = temp;
        return new String(chars);
    }

    public int slidingPuzzle(int[][] board) {
        // ��ʼ״̬ת�ַ���
        char[] chars = new char[6];
        int index = 0;
        for (int[] row : board) {
            for (int ch : row) {
                chars[index++] = (char) (ch + '0');
            }
        }

        String start = new String(chars);
        String target = "123450";
        // BFS��·
        Queue<String> q = new ArrayDeque<>();
        //������ʹ������ݽṹ
        Set<String> visited = new HashSet<>();
        q.offer(start);
        int step = 0;
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                // �⿪�հ�
                if (cur.equals(target)) {
                    return step;
                }
                //�ҵ�����0������
                int position = cur.indexOf('0');
                //�ҵ�����Ϊ0����������
                int[] exchanges = exchangeArray[position];
                for (int next : exchanges) {
                    String s = exchangeString(cur, position, next);
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            step++;
        }
        return -1;
    }


    public static void main(String[] args) {
        HuaDongPingTu hu = new HuaDongPingTu();

    /*    int[][] board = new int[][]{
                {1, 2, 3},
                {5, 4, 0}
        };
        System.out.println(hu.slidingPuzzle(board));*/

        int[][] board2 = new int[][]{
                {1, 2, 3},
                {4, 0, 5}
        };
        System.out.println(hu.slidingPuzzle(board2));
    }
}

