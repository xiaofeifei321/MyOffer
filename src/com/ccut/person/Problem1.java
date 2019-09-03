package com.ccut.person;

public class Problem1 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int[][] arry = new int[][]{{1, 2, 3, 4, 5}, {2, 4, 7, 8, 10}};
        Problem1 problem1 = new Problem1();
        System.out.println(arry[0].length);
        System.out.println(arry.length);
        System.out.println(problem1.find(arry, 8));
    }

    public Boolean find2(int[][] arry, int k) {
        if (arry == null || arry.length == 0 || (arry.length == 1 || arry[0].length == 0))
            return false;
        int i = arry.length - 1;
        int j = 0;
        while (i >= 0 && j < arry[0].length) {
            if (arry[i][j] > k) {
                i--;
            } else if (arry[i][j] < k) {
                j++;
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     *
     */


    /**
     * 暴力破解
     */
    private Boolean find(int[][] arry, int k) {
        if (arry == null || arry.length == 0 || (arry.length == 1 && arry[0].length == 0)) return false;
        for (int i = 0; i < arry.length; i++) {
            for (int j = 0; j < arry[0].length; j++) {
                if (k == arry[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
