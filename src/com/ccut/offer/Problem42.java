package com.ccut.offer;

/**
 * 反转单词顺序VS左旋转字符串
 * 输入一个英文句，翻转句子中单词的顺序，
 *      题目:输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串为“I am a Student.",则输出为”Student. a am i".
 *   解法1 ：翻转出句子中所有字符，比如翻转“I am a Student"中所有的字符得到”.tneduts a ma i",此时不但翻转了句子中单词的顺序，连单词内的字符顺序也被翻转了。第二步再反转每个单词中字符的顺序，就得到了“student. a am I
 *
 *  题目2：左旋转字符串
 *     字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转的功能。比如输入字符串”ab cdefg"和数字2,该函数将返回左旋转2位得到的结果“cdefg ab"
 *   解法1：
 *    在第一个问题中，如果输入的字符串之中只有两个单词，比如”hello World"，那么翻转这个句子中的单词顺序就得到了“world hello",比较这两个字符串，我们是不是可以把”world hello"看成是把原始字符串“hello world"的前面若干个字符转移到后面？也就是说这两个问题非常相似，我们同样可以通过反转字符串的办法来解决第二个问题。
 *    以”abcdeftg"为例，我们可以把它分为两个部分，由于想把它的前两个字符一道后面，我们就把前面两个字符分到第一部分，把后面的所有字符都分到第二个部分。我们先反转这两部分，于是就得到了“bagfedc"，接下来我们再翻转整个字符串，得到了”cdefgab"刚好就是把原始字符串左旋转2位的结果。
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
