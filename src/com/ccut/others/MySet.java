package com.ccut.others;

public class MySet {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array1 = {1, 3, 5, 6, 9, 20};
        int[] array2 = {3, 5, 7, 9, 10, 23, 45};
        
        int[] arrayA = { 1, 2, 5, 9, 10 };
		int[] arrayB = { 2, 5, 16 };
        getComplement(arrayA, arrayB);
        getIntersection(array1, array2);
        getUnion(array1, array2);

    }

    /**
     * 求两个数组的补集
     * @param array1
     * @param array2
     */
    public static void getComplement(int[] array1, int[] array2) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                index1++;
                index2++;
            } else if (array1[index1] < array2[index2]) {
                System.out.println(array1[index1]);
                index1++;
            } else {
                System.out.println(array2[index2]);
                index2++;
            }

            if (index1 == array1.length) {
                while (index2 < array2.length) {
                    System.out.println(array2[index2]);
                    index2++;
                }
            }

            if (index2 == array2.length) {
                while (index1 < array1.length) {
                    System.out.println(array1[index1]);
                    index1++;
                }
            }
        }
        System.out.println("----------------------");
    }

    /**
     * 求两个数组的并集
     * @param array1
     * @param array2
     */
    public static void getUnion(int[] array1, int[] array2) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                System.out.println(array1[index1]);
                index1++;
                index2++;
            } else if (array1[index1] < array2[index2]) {
                System.out.println(array1[index1]);
                index1++;
            } else {
                System.out.println(array2[index2]);
                index2++;
            }

            if (index1 == array1.length) {
                while (index2 < array2.length) {
                    System.out.println(array2[index2]);
                    index2++;
                }
            }

            if (index2 == array2.length) {
                while (index1 < array1.length) {
                    System.out.println(array1[index1]);
                    index1++;
                }
            }
        }
        System.out.println("----------------------");
    }

    /**
     * 求两个数组的交集
     * @param array1
     * @param array2
     */
    public static void getIntersection(int[] array1, int[] array2) {
        int index1 = 0;
        int index2 = 0;
        while(index1 < array1.length && index2 < array2.length) {
            if (array1[index1] == array2[index2]) {
                System.out.println(array1[index1]);
                index1++;
                index2++;
            } else if (array1[index1] < array2[index2]) {
                index1++;
            } else {
                index2++;
            }
        }
        System.out.println("----------------------");
    }
}
