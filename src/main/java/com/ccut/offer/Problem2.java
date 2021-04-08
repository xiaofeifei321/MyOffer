package com.ccut.offer;

/**
 * 字符串替换空格
 * <p>
 * 从字符串的后面开始复制和替换，首先准备两个指针，p1和p2，
 * p1指向原始字符串的末尾，p2指向替换后字符串的末尾，接下来，向前移动指针p1，
 * 逐个把它指向的字符复制到p2，碰到一个空格之后，把p1向前移动1格，在p2处插入字符串“20%”，
 * 由于“20%”长度为3，同时也要把p2向前移动3格。直到p1=p2，表明所有空格都已经替换完毕
 */
public class Problem2 {
    public static void main(String[] args) {
        Problem2 problem2 = new Problem2();
        StringBuffer str = new StringBuffer("We Are Happy");
        String temp="We Are Happy";
        //替换之后的空格
        problem2.replaceAllBlank(temp);
    }

    /**
     * 时间复杂度最好的
     */
    //计算字符串中包含的空格个数
    public static int getBlankNum(String testString) {
        int count = 0;
        for (int i = 0; i < testString.length(); i++) {
            String tempString = String.valueOf(testString.charAt(i));
            if (tempString.equals(" ")) {
                count++;
            }
        }
        return count;
    }

    //打印char[] 数组
    public static void printArray(char[] testArray) {
        for (char i : testArray) {
            System.out.print(i);
        }
        System.out.println();
    }

    //将字符串空格转化为20%
    public static void replaceAllBlank(String testString) {
        if (testString == null || testString.length() <= 0) {
            return;
        }
        //字符数组初始长度
        int length = testString.length();
        //字符数组增加长度后
        int newLength = testString.length() + getBlankNum(testString) * 2;
        char[] tempArray = new char[newLength];
        System.arraycopy(testString.toCharArray(), 0, tempArray, 0, testString.toCharArray().length);
        int indexofOriginal = length - 1;
        int indexofNew = newLength - 1;
        System.out.println("未替换空格时的字符串：");
        printArray(testString.toCharArray());
        while (indexofOriginal >= 0 && indexofOriginal != indexofNew) {
            if (tempArray[indexofOriginal] == ' ') {
                tempArray[indexofNew--] = '0';
                tempArray[indexofNew--] = '2';
                tempArray[indexofNew--] = '%';
            } else {
                tempArray[indexofNew--] = tempArray[indexofOriginal];
            }
            indexofOriginal--;
        }
        System.out.println("替换空格后的字符串：");
        printArray(tempArray);
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