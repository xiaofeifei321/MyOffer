package com.labuladong.shuzu;

import java.util.LinkedList;

/**
 * �Ǽ��� ab �� 1337 ȡģ��a ��һ����������b ��һ���ǳ�����������һ���������ʽ����
 * <p>
 * ���룺a = 2, b = [3]
 * �����8
 * <p>
 * ���룺a = 2, b = [1,0]
 * �����1024
 * <p>
 * ���룺a = 1, b = [4,3,3,8,5,2]
 * �����1
 */
public class NChiFangSulution {
    int mu = 1337;

    public int superPow(int a, int[] b) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int bb : b) {
            list.add(bb);
        }
        return superP(a, list);

    }

    public int superP(int a, LinkedList<Integer> list) {
        if (list.isEmpty()) {
            return 1;
        }
        int last = list.peekLast();
        list.pollLast();
        int res1 = quickMul(a, last);
        int res2 = quickMul(superP(a, list), 10);
        return res1 * res2 % mu;
    }

    public int quickMul(int a, int n) {

        if (n == 0) {
            return 1;
        }
        a %= 1337;
        int ans = 1;
        int x = a;
        while (n > 0) {
            if (n % 2 == 1) {
                ans = ans * x % mu;
            }
            x = x * x % mu;
            n /= 2;
        }
        return ans % mu;
    }
}
