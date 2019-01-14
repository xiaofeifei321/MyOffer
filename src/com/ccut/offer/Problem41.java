package com.ccut.offer;
/**
 * 和为s的两个数字VS和为s的连续正数序列 
 */
public class Problem41 {
	public void findNumbersWithSum(int[] sortedArray, int number) {
		if (sortedArray == null)
			return;
		int pointHead = 0;
		int pointEnd = sortedArray.length - 1;
		while (pointEnd > pointHead) {
			long curSum = sortedArray[pointEnd] + sortedArray[pointHead];
			if (curSum == number) {
				System.out.println(sortedArray[pointHead]);
				System.out.println(sortedArray[pointEnd]);
				break;
			} else {
				if (curSum > number)
					pointEnd--;
				else
					pointHead++;
			}
		}
	}
	
	/**
	 * 打印连续的队列
	 * @param s
	 */
	public void findContinuousSequence(int s){
		if(s < 4)
			return ;
		int small = 1;
		int big = 2;
		//字符中至少包含两个数字
		while(small <(s+1)/2){
			int curSum = 0;
			for(int i = small ;i<=big;i++)
				curSum +=i;
			if(curSum == s){
				System.out.println("find one");
				for(int i = small;i<=big;i++)
					System.out.print(i+"+");
				small++;
			}else{
				if(curSum > s)
					small++;
				else
					big++;
			}
		}
	}

	public static void main(String[] args) {
        int[]arr={1,2,3,4,5,7,8};
        Problem41 problem41=new Problem41();
//        problem41.findNumbersWithSum(arr, 15);
        problem41.findContinuousSequence(15);
	}

}
