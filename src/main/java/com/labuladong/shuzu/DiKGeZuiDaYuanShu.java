package com.labuladong.shuzu;

/**
 * 数组中的第K个最大元素
 * 在未排序的数组中找到第K个最大的元素
 * 输入：[3,2,1,5,6,4] 和K=2
 * 输出：5
 */
public class DiKGeZuiDaYuanShu {
    int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        //进行索引转化，这个值数组排序之后的第nums.length-k个元素
        k = nums.length - k;
        while (lo <= hi) {
            //在nums[lo...hi]中选一个分界点
            int p = partition(nums, lo, hi);
            if (p < k) {
                //第k大元素在nums[p+1...hi]中
                lo = p + 1;
            } else if (p > k) {
                //第k大元素在nums[lo,p-1]中
            } else {
                //找到第k大元素
                return nums[p];
            }
        }
        return -1;
    }

    public int partition(int[] nums, int lo, int hi) {
        if (lo==hi) {
            return  lo;
        }
        //将nums[lo]作为默认分界点 privot
        int pivot=nums[lo];
       //j=hi+1因为while中会先执行--
        int i=lo,j=hi+1;
        while (true){
            while (nums[++i] < pivot) {
                if (i == hi) break;
            }
            // 保证 nums[j..hi] 都大于 pivot
            while (nums[--j] > pivot) {
                if (j == lo) break;
            }
            if (i >= j) break;
            // 如果走到这里，一定有：
            // nums[i] > pivot && nums[j] < pivot
            // 所以需要交换 nums[i] 和 nums[j]，
            // 保证 nums[lo..i] < pivot < nums[j..hi]
            swap(nums, i, j);
        }
        return 1;
    }

    // 交换数组中的两个元素
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}




