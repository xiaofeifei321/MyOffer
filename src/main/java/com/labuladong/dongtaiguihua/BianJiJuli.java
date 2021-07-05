package com.labuladong.dongtaiguihua;

/**
 * �༭���룺
 * ������������Word1��Word2����Word1ת��ΪWord2���õ���С������
 * ���ԶԵ��ʽ������ֲ���
 * ����һ���ַ�
 * ɾ��һ���ַ�
 * �滻һ���ַ�
 * ʾ��
 * ���룺word1 = "horse", word2 = "ros"
 * �����3
 * ���ͣ�
 * horse -> rorse (�� 'h' �滻Ϊ 'r')
 * rorse -> rose (ɾ�� 'r')
 * rose -> ros (ɾ�� 'e')
 */
public class BianJiJuli {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        // ��һ���ַ���Ϊ�մ�
        if (n * m == 0) {
            return n + m;
        }
        // DP ����
        int[][] D = new int[n + 1][m + 1];

        // �߽�״̬��ʼ��
        for (int i = 0; i < n + 1; i++) {
            D[i][0] = i;
        }
        for (int j = 0; j < m + 1; j++) {
            D[0][j] = j;
        }

        // �������� DP ֵ
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //ɾ��
                int left = D[i - 1][j] + 1;
                //���룬��s1[i]����һ����s2[j]һ�����ַ�.s2[j]��ƥ�䣬ǰ��j��������i���Ա�
                int down = D[i][j - 1] + 1;
                //�滻����
                int left_down = D[i - 1][j - 1];
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    left_down += 1;
                }
                D[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return D[n][m];
    }


    public static void main(String[] args) {
        BianJiJuli bianJiJuli = new BianJiJuli();
        String a = "rad";
        String b = "apple";
        System.out.println(bianJiJuli.minDistance(a, b));
    }
}
