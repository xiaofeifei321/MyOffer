package com.ccut.offer;
/**
 * 旋转数组最小数字
 * 例如数组｛3，4，5，1，2｝为{1,2,3,4,5}的一个旋转，该数组的最小元素为1
     Step1.和二分查找法一样，我们用两个指针分别指向数组的第一个元素和最后一个元素。
 　　Step2.接着我们可以找到数组中间的元素：
 　　如果该中间元素位于前面的递增子数组，那么它应该大于或者等于第一个指针指向的元素。此时数组中最小的元素应该位于该中间元素的后面。我们可以把第一个指针指向该中间元素，这样可以缩小寻找的范围。移动之后的第一个指针仍然位于前面的递增子数组之中。如果中间元素位于后面的递增子数组，
      那么它应该小于或者等于第二个指针指向的元素。此时该数组中最小的元素应该位于该中间元素的前面。
 　　Step3.接下来我们再用更新之后的两个指针，重复做新一轮的查找。
 */
public class Problem6 {
	public int minInReversingList(int[] arr){
		if(arr==null){
			return -1;
		}
		int leftIndex = 0;
		int rightIndex = arr.length -1;
		int midIndex = leftIndex;
		while(arr[leftIndex]>= arr[rightIndex]){
			if(rightIndex - leftIndex <= 1){
				midIndex = rightIndex;
				break;
			}
			midIndex = (leftIndex+rightIndex)/2;
			//这种情况是防止{1，0，1,1,1}这种情况
			if(arr[leftIndex]== arr[rightIndex] && arr[midIndex]== arr[leftIndex]){
				return MinInOrder(arr,leftIndex,rightIndex);
			}
			if(arr[midIndex] >= arr[leftIndex]){
				leftIndex = midIndex;
			}else if(arr[midIndex] < arr[rightIndex]){
				rightIndex = midIndex;
			}
		}
		return arr[midIndex];
	}
	
	//顺序查找
	public int MinInOrder(int[] arr,int leftIndex,int rightIndex){
		int result = arr[leftIndex];
		for(int i = leftIndex +1;i<rightIndex;i++){
			if(result> arr[i]){
				result = arr[i];
			}
		}
		return result;
	}
	public static void main(String[] args){
		Problem6 test = new Problem6();
		int[] arr={2,2,2,2,2,0,1,2,2};//
		System.out.println(test.minInReversingList(arr));
	}
}
