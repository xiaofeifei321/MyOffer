package com.labuladong.shuzu;

import cn.hutool.json.JSONUtil;

/**
 * �������
 */
public class Difference {
    /**
     * ����������
     */
    private int[] diff;

    public Difference(int[] nums) {
        assert nums.length > 0;
        diff = new int[nums.length];
        //����������
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * ��������[i,j]����val(�����Ǹ���)
     */
    public void increment(int i, int j, int val) {
        diff[i] = diff[i] + val;
        //˵���Ƕ�nums[i]���Ժ���������鶼�����޸ģ���ô�Ͳ���Ҫ�ٸ�diff�����val�ˡ�
        if (j + 1 < diff.length) {
            diff[j + 1] = diff[j + 1] - val;
        }
    }

    public int[] result() {
        int[] res = new int[diff.length];
        //���ݲ�����鹹��������
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

    /**
     * ����Ԥ��
     *
     * @param bookings
     * @param n
     * @return
     */
    public int[] corpFilghtBooking(int[][] bookings, int n) {
        //nums ��ʼ��ȫΪ0
        int[] nums = new int[n];
        //�����ֽⷨ
        Difference df = new Difference(nums);
        for (int[] booking : bookings) {
            int i = booking[0] - 1;
            int j = booking[1] - 1;
            int val = booking[2];
            // ������ nums[i..j] ���� val
            df.increment(i, j, val);
        }
        // �������յĽ������
        return df.result();
    }


    public static void main(String[] args) {

       /* int[][] bookings={{1,2,10},{2,3,20},{2,5,25}};
        Difference difference=new Difference(5);
        System.out.println(JSONUtil.toJsonStr(bookings,5));*/
    }

}
