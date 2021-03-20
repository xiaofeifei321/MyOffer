package com.labuladong.shuzu;

import java.util.Arrays;

/**
 * �������� [2, n) ���м�������
 */
public class ShushuoSolution {
    int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrim(i))
            {
                count++;
                System.out.println("������"+i);
            }
        }
        return count;
    }
    //�ж�����n�Ƿ�Ϊ����
    boolean isPrim(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    int countPrimesTwo(int n) {
        boolean[] isPrim = new boolean[n];
        // �����鶼��ʼ��Ϊ true
        Arrays.fill(isPrim, true);

        for (int i = 2; i < n; i++)
            if (isPrim[i]) {
                // i �ı�����������������
                for (int j = 2 * i; j < n; j += i){
                    isPrim[j] = false;
                    System.out.println("j="+j);
                }

            }
        int count = 0;
        for (int i = 2; i < n; i++)
            if (isPrim[i]) count++;
        return count;
    }

    public static void main(String[] args) {
        ShushuoSolution shushuoSolution=new ShushuoSolution();
        System.out.println(shushuoSolution.countPrimesTwo(10));
    }
}
