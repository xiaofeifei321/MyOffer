package com.ccut.offer;

/**
 * 反转单词顺序VS左旋转字符串
 */
public class Problem42 {
    public String reverse(String str) {
        char[] array = str.toCharArray();
        for (int i = 0; i < (array.length) / 2; i++) {
            char temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - i - 1] = temp;
        }
        return String.valueOf(array);
    }

    public void reverseSentence(String sentence) {
        if (sentence == null)
            return;
        String sentenceReverse = reverse(sentence);
        String[] splitStrings = sentenceReverse.split(" ");
        String resultBuffer = "";
        for (String s : splitStrings)
            resultBuffer = resultBuffer + reverse(s) + " ";
        System.out.println(resultBuffer);
    }

    //____________
    public void leftRotateString(String sentence, int index) {
        if (sentence == null || index > sentence.length() || index < 0)
            return;
        String[] splitStrings = {sentence.substring(0, index), sentence.substring(index, sentence.length())};
        String resultBuffer = "";
        for (int i = 0; i < splitStrings.length; i++) {
            splitStrings[i] = reverse(splitStrings[i]);
            resultBuffer += splitStrings[i];
        }
        System.out.println(reverse(resultBuffer));
    }


    public static void main(String[] args) {
        Problem42 problem42 = new Problem42();
//		problem42.reverseSentence("I am a sthdents .");
        String str = "abcdefg";
        problem42.leftRotateString(str, 2);
    }

}
