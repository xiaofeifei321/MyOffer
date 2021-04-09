package com.labuladong.shuzu;

import cn.hutool.json.JSONUtil;

/**
 * 差分数组
 */
public class Difference {
    /**
     * 构造差分数组
     */
    private int[] diff;

    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        //构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间[i,j]增加val(可以是附属)
     */
    public void increment(int i, int j, int val) {
        diff[i] = diff[i] + val;
        //说明是对nums[i]及以后的整个数组都进行修改，那么就不需要再给diff数组减val了。
        if (j + 1 < diff.length) {
            diff[j + 1] = diff[j + 1] - val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        //根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    /**
     * 航班预订
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFilghtBooking(int[][] bookings, int n) {
        //nums 初始化全为0
        int[] nums = new int[n];
        //构造差分解法
        Difference df = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // 对区间 nums[i..j] 增加 val
            df.increment(i, j, val);
        }
        // 返回最终的结果数组
        return df.result();
    }


    public static void main(String[] args) {

       /* int[][] bookings={{1,2,10},{2,3,20},{2,5,25}};
        Difference difference=new Difference(5);
        System.out.println(JSONUtil.toJsonStr(bookings,5));*/
    }

}
