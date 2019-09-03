package com.ccut.others;

import java.sql.Array;

public class TSet {
    public static void main(String[] args) {
        int[] arrayA = {2};
        int[] arrayB = {2, 5, 16, 5, 10, 19, 22};
        getComplent(arrayA, arrayB);
        System.out.println("---------------------");
        getUnion(arrayA, arrayB);
        System.out.println("---------------------");
    }

    public static void getInsetSelect(int[] arrayA, int[] arrayB) {
        int i = 0, j = 0;
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] == arrayB[j]) {
                System.out.print(arrayA[i] + " ");
                i++;
                j++;
            } else if (arrayA[i] < arrayB[j]) {
                i++;
            } else if (arrayA[i] > arrayB[j]) {
                j++;
            }
        }
    }

    private static void getUnion(int[] arrayA, int[] arrayB) {
        int i = 0, j = 0;
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] == arrayB[j]) {
                System.out.print(arrayA[i] + " ");
                i++;
                j++;
            } else if (arrayA[i] < arrayB[j]) {
                System.out.print(arrayA[i] + " ");
                i++;
            } else if (arrayA[i] > arrayB[j]) {
                System.out.print(arrayB[j] + " ");
                j++;
            }

        }
        if (i == arrayA.length) {
            while (j != arrayB.length) {
                System.out.print(arrayB[j] + " ");
                j++;
            }
        }
        if (j == arrayB.length) {
            while (i != arrayA.length) {
                System.out.print(arrayB[i] + " ");
                i++;
            }
        }
    }

    public static void getComplent(int[] arrayA, int[] arrayB) {
        int i = 0, j = 0;
        while (i < arrayA.length && j < arrayB.length) {
            if (arrayA[i] == arrayB[j]) {
                i++;
                j++;
            } else if (arrayA[i] < arrayB[j]) {
                System.out.print(arrayA[i] + " ");
                i++;
            } else if (arrayA[i] > arrayB[j]) {
                System.out.print(arrayB[j] + " ");
                j++;
            }
        }
        if (i == arrayA.length) {
            while (j < arrayB.length) {
                System.out.print(arrayB[j] + " ");
                j++;
            }
        }
        if (j == arrayB.length) {
            while (i < arrayA.length) {
                System.out.print(arrayB[i] + " ");
                i++;
            }
        }
    }
}
