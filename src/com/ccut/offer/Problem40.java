package com.ccut.offer;
/**
 * 数组出现一次的数字 
 */
public class Problem40 {
	public void findNumsAppearOnce(int[] arr){
		if(arr == null)
			return;
		int number = 0;
		for(int i: arr)
		{
			number=number^i;
			System.out.println("测试"+number);
		}
		
		int index = findFirstBitIs1(number);
		int number1= 0,number2 = 0;
		for(int i : arr){
			if(isBit1(i,index))
				number1^=i;
			else
				number2^=i;
		}
		System.out.println(number1);
		System.out.println(number2);
	}
	private int findFirstBitIs1(int number){
		int indexBit = 0;
		while((number & 1)== 0){
			number = number >> 1;
			++indexBit;
		}
		return indexBit;
	}
	private boolean isBit1(int number,int index){
		number = number >>index;
		return (number & 1) == 0;
	}
	public static void main(String[] args){
		int[] arr={2,4,3,6,3,2,5,5};
		Problem40 test = new Problem40();
		test.findNumsAppearOnce(arr);
	}
}
