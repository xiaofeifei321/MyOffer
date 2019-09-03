package com.ccut.offer;

/**
 * 扑克牌的顺序
 */
public class Problem44 {
    /**
     * 做三件事 1:将数据排序 2:统计数组中零的个数 3 :统计相邻数据中空缺数字
     */
    public boolean isContinous(int[] arr) {
        if (arr == null || arr.length != 5)
            return false;
        int countOf0 = (arr[0] == 0 ? 1 : 0);
        int dis = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0)
                countOf0++;
            int t = arr[i];
            int j = 0;
            for (j = i - 1; j >= 0; j--) {
                if (t != 0 && t == arr[j])
                    return false;
                else if (t > arr[j])
                    break;
                else
                    arr[j + 1] = arr[j];
            }
            arr[j + 1] = t;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] != 0)
                dis += arr[i + 1] - arr[i] - 1;
        }
        if (dis <= countOf0)
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        int[] arr = {0, 8, 1, 2, 5};
        Problem44 test = new Problem44();
        System.out.println(test.isContinous(arr));
    }

}
