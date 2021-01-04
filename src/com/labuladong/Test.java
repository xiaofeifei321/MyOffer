package com.labuladong;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[][] nums=new int[][]{{1,3},{1,2},{4,5},{3,7}};
        Arrays.sort(nums, (a, b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        System.out.println(Arrays.toString(nums));
        List  list=new ArrayList();


    }
}
