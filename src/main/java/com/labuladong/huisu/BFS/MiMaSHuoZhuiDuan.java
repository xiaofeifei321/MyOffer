package com.labuladong.huisu.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * leedCode 752
 * 输入：deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * 输出：6
 * 解释：
 * 可能的移动序列为 "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202"。
 * 注意 "0000" -> "0001" -> "0002" -> "0102" -> "0202" 这样的序列是不能解锁的，
 * 因为当拨动到 "0102" 时这个锁就会被锁定。
 */
public class MiMaSHuoZhuiDuan {
    /**
     * BFS框架，打印若有可能
     *
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {
        Queue<String> q = new LinkedList();
        Set<String> visited = new HashSet();

        Set<String> deads = new HashSet();
        q.offer("0000");//将起点加入队列中
        visited.add("0000");
        int step = 0;//记录扩散的步数
        for (String s : deadends) {
            deads.add(s);
        }

        while (!q.isEmpty()) {
            int sz = q.size();
            //当前节点向四周扩散
            for (int i = 0; i < sz; i++) {
                String cur = q.poll();
                //到达终点
                if (cur.equals(target))
                    return step;
                if (deads.contains(cur))
                    continue;
                //将一个节点的相邻节点介入到队列当中
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
     * 将 s[j] 向上拨动一次
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
     * 将 s[i] 向下拨动一次
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
