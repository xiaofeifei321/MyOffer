package com.labuladong.shuzu;

/**
 * 前缀数组和差分数组
 *   前缀数据：适用于频繁查询某一个区间的累加和
 *   差分数组：差分数组主要适用于频繁对原始数组的某一个区间的元素进行增减
 */
public class ChaFenShuZhuDifference {

    private int[] diff;

    /**
     * 构造差分数组
     */
    public ChaFenShuZhuDifference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        //构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间[i,j]增加val(可以是负数)
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
        ChaFenShuZhuDifference df = new ChaFenShuZhuDifference(nums);
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
