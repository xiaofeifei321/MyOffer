package com.labuladong.shuzu;

/**
 * �����еĵ�K�����Ԫ��
 * ��δ������������ҵ���K������Ԫ��
 * ���룺[3,2,1,5,6,4] ��K=2
 * �����5
 */
public class DiKGeZuiDaYuanShu {
    int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        //��������ת�������ֵ��������֮��ĵ�nums.length-k��Ԫ��
        k = nums.length - k;
        while (lo <= hi) {
            //��nums[lo...hi]��ѡһ���ֽ��
            int p = partition(nums, lo, hi);
            if (p < k) {
                //��k��Ԫ����nums[p+1...hi]��
                lo = p + 1;
            } else if (p > k) {
                //��k��Ԫ����nums[lo,p-1]��
            } else {
                //�ҵ���k��Ԫ��
                return nums[p];
            }
        }
        return -1;
    }

    public int partition(int[] nums, int lo, int hi) {
        if (lo==hi) {
            return  lo;
        }
        //��nums[lo]��ΪĬ�Ϸֽ�� privot
        int pivot=nums[lo];
       //j=hi+1��Ϊwhile�л���ִ��--
        int i=lo,j=hi+1;
        while (true){
            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            // ��֤ nums[j..hi] ������ pivot
            while (nums[--j] > pivot) {
                if (j == lo) break;
            }
            if (i >= j) break;
            // ����ߵ����һ���У�
            // nums[i] > pivot && nums[j] < pivot
            // ������Ҫ���� nums[i] �� nums[j]��
            // ��֤ nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        return 1;
    }

    // ���������е�����Ԫ��
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}




