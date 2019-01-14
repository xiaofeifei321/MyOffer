package com.ccut.offer;
/**
 * 从字符串的后面开始复制和替换，首先准备两个指针，p1和p2，
 * p1指向原始字符串的末尾，p2指向替换后字符串的末尾，接下来，向前移动指针p1，
 * 逐个把它指向的字符复制到p2，碰到一个空格之后，把p1向前移动1格，在p2处插入字符串“20%”，
 * 由于“20%”长度为3，同时也要把p2向前移动3格。直到p1=p2，表明所有空格都已经替换完毕
 */
public class Problem2 {
	public static void main(String[] args) {
		Problem2 problem2 = new Problem2();
		StringBuffer str = new StringBuffer("We Are Happy");
		System.out.println(problem2.replaceSpace(str));
	}

	/**
	 * 新建字符串，遍历原字符串，当发现空格时，在新字符串添加%20，否则添加原字符串中的数据，不改变原数据
	 */
	public String replaceSpace_3(StringBuffer str) {
		if (str == null) {
			return null;
		}
		StringBuffer newStr = new StringBuffer();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == (' ')) {
				newStr.append('%');
				newStr.append('2');
				newStr.append('0');
			} else {
				newStr.append(str.charAt(i));
			}

		}
		return newStr.toString();
	}

	/**
	 * 直接把StringBuffer转换成String调用replaceAll方法，改变原数据
	 */
	public String replaceSpace_2(StringBuffer str) {
		if (str == null) {
			return null;
		}
		return str.toString().replaceAll(" ", "%20");
	}

	/**
	 * 遍历字符串，当发现空格时，替换空格，改变原数据
	 */
	public String replaceSpace(StringBuffer str) {
		if (str == null) {
			return null;
		}
		int i = 0, j;
		while (i < str.length()) {
			if ((j = str.indexOf(" ")) != -1) {
				str.replace(j, j + 1, "%20");
				i += 2;
			}
			i++;
		}
		return str.toString();
	}
}