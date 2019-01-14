package com.ccut.offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 判断是否为丑数
 * @author root
 *
 */
public class Problem34Second {
	 public static void main(String[] args) {
	            //输入数据
	            int result = getUglyNumber(7);
	            System.out.println(result);
	    }

	    private static int getUglyNumber(int index) {
	        if (index <= 0) {
	            return 0;
	        }
	        //存放丑数
	        List<Integer> list = new ArrayList<>();
	        list.add(1);
	        int i2 = 0, i3 = 0, i5 = 0;
	        while (list.size() < index) {
	            int num2 = list.get(i2) * 2;
	            int num3 = list.get(i3) * 3;
	            int num5 = list.get(i5) * 5;
	            //找出最小的丑数，保证是按照从小到大的顺序排列
	            int min = Math.min(num2, Math.min(num3, num5));
	            list.add(min);
	            //保证最小的数不重复
	            if (min == num2) {
	                i2++;
	            }
	            if (min == num3) {
	                i3++;
	            }
	            if (min == num5) {
	                i5++;
	            }
	        }
	        //返回第N个丑数
	        return list.get(list.size() - 1);
	    }
	}