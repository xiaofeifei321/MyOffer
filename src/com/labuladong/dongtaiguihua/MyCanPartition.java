package com.labuladong.dongtaiguihua;

/**
 * ��̬�滮
 * ��Ŀ 416. �ָ�Ⱥ��Ӽ�
 * ����һ��ֻ�����������ķǿ����顣�Ƿ���Խ��������ָ�������Ӽ���ʹ�������Ӽ���Ԫ�غ���ȡ�
 * ����: [1, 5, 11, 5]
 * ���: true
 * ����: ������Էָ�� [1, 5, 5] �� [11].
 */
public class MyCanPartition {
    public static boolean canPartition(int[] nums) {
        int sum = 0;
        //��������ĺ�sum�����sumΪ�������ǿ϶����ֳܷ������֣�ֱ�ӷ���false
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if (sum % 2 != 0)
            return false;
        sum = sum / 2;
        //��ʼ��base case :dp[...][0] = true���൱�ڵ�������Ϊ0��ʱ�򣬿϶�ʲô����Ҳ���÷ţ������϶�Ĭ�������ģ���Ϊ������Ϊ0�������true;dp[0][...] = false,�൱������һ������ʱ
        // ʲô���������ţ��ǿ϶�����û������������false
        /**
         *  sum = sum / 2;
         *  dp���麬�壺dp[i][j] = x
         *  ��ʾ����ǰi����Ʒ������������j������ʱ��
         *  ��x = true����ʾ�����պ�װ����
         *  ��x = flase����ʾ��������װ����
         */
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i < nums.length + 1; i++)
            dp[i][0] = true;
        //�������ʡ�ԣ���Ϊjava��boolean��Ĭ����false������û��ע�͵�����Ϊ����߼���������
        for (int i = 0; i < sum + 1; i++)
            dp[0][i] = false;
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                // ֱ�Ӵ���һ���Ȱѽ����������Ȼ��������
                dp[i][j] = dp[i - 1][j];
                //�����ǰ�ı���������Ҫ�ŵ�������С���Ǿ�û���ţ�ֻ�ܼ̳�֮ǰ��״̬
                if (j < nums[i - 1]) {
                    //�����������㣬����װ���i����Ʒ
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //������߲����룬��������״̬��ֻҪ�ܷ����Ϳ���
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(nums.length);
        System.out.println(MyCanPartition.canPartition(nums));
    }

}

