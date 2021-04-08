package com.labuladong.huisu.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leedCode 752
 * ���룺deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * �����6
 * ���ͣ�
 * ���ܵ��ƶ�����Ϊ "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"��
 * ע�� "0000" -> "0001" -> "0002" -> "0102" -> "0202" �����������ǲ��ܽ����ģ�
 * ��Ϊ�������� "0102" ʱ������ͻᱻ������
 */
public class MiMaSHuoZhuiDuan {
    /**
     * BFS��ܣ���ӡ���п���
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();

        Set<String> deads = new HashSet();
        q.offer("0000");//�������������
        visited.add("0000");
        int step = 0;//��¼��ɢ�Ĳ���
        for (String s : deadends) {
            deads.add(s);
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            //��ǰ�ڵ���������ɢ
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                //�����յ�
                if (cur.equals(target))
                    return step;
                if (deads.contains(cur))
                    continue;
                //��һ���ڵ�����ڽڵ���뵽���е���
                for (int j = 0; j < 4; j++) {
                    String up = upString(cur, j);
                    String down = downString(cur, j);
                    if (!visited.contains(up)) {
                        q.offer(up);
                        visited.add(up);
                    }

                    if (!visited.contains(down)) {
                        q.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    /**
     * �� s[j] ���ϲ���һ��
     *
     * @param j
     * @return
     */
    public String upString(String curr, int j) {
        char[] ch = curr.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    /**
     * �� s[i] ���²���һ��
     *
     * @param curr
     * @return
     */
    public String downString(String curr, int j) {
        char[] ch = curr.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
