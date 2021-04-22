package com.labuladong.shuzu;

import java.util.Vector;

/**
 * ����n�η�
 * ���� a��b�η� �� 1337 ȡģ��a ��һ����������b ��һ���ǳ�����������һ���������ʽ����
 * ʾ����
 * ���� a=2��b=[3]
 * ��� ��8
 * <p>
 * ���� a=2��b=[1,0]
 * �����1024
 */
public class ChaoJiNChiFang {
    int base = 1337;
    int index = 1;

    public int superPow(int a, int[] b) {
        //���鳤��
        int l = b.length;
        //�ݹ��base case
        if (index == l) {
            return myPow(a, b[0]);
        }
        int pary1 = superMyPow(a, b[l - index++]);
        int part2 = superMyPow(superPow(a, b), 10);
        //�ϲ����
        return (pary1 * part2) % base;
    }

    public int myPow(int a, int b) {
        int ans = 1;
        //��������ģ
        a %= base;
        for (int i = 1; i <= b; i++) {
            //�����г˷���Ǳ�ڵ������
            ans *= a;
            //�Գ˷������ģ
            ans %= base;
        }
        return ans;
    }

    /**
     * ��Ч����
     *
     * @param
     */

    public int superMyPow(int a, int k) {
        if (k == 0) {
            return 1;
        }
        if (k % 2 == 1) {
            //����Ϊ����
            return (a * superMyPow(a, k - 1)) % base;
        } else {
            //����Ϊż��
            int sub = superMyPow(a, k / 2);
            return (sub * sub) % base;
        }
    }


    public static void main(String[] args) {
        ChaoJiNChiFang chaoJiNChiFang = new ChaoJiNChiFang();
        int a[] = {1, 0};
        System.out.println(chaoJiNChiFang.superPow(2, a));
    }

}
