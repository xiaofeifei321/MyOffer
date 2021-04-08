package com.ccut.offer;

/**
 * 青蛙跳台阶问题
 */
public class Problem8 {
    public static void main(String[] args) {
        Problem8 solution04 = new Problem8();
        System.out.println(solution04.JumpFloor_2(3));
    }

    /**
     * 直接用递归 * 对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以 F(n) = F(n-1) + F(n-2) f(1)=1
     * f(2)=2
     */
    public int JumpFloor(int target) {
        if (target <= 1) {
            return 1;
        }
        if (target <= 2) {
            return 2;
        } else {
            return JumpFloor(target - 1) + JumpFloor(target - 2);
        }
    }

    /**
     * 用迭代的方法，用两个变量记录f(n-1) f(n-2)
     *
     * @param target 台阶数
     * @return 跳法
     */
    public int JumpFloor_2(int target) {
        int one = 1, two = 2, fN = 0;
        if (target <= 0) {
            return 0;
        } else if (target == 1) {
            return 1;
        } else if (target == 2) {
            return 2;
        } else {
            for (int i = 3; i <= target; i++) {
                fN = one + two;
                one = two;
                two = fN;
            }
            return fN;
        }
    }

    /**
     * 变态青蛙跳台阶问题 f(n)=2f(n-1)
     */
    // 思路: 接上一个跳台阶问题思路继续分析，上个问题中，青蛙只能跳1级或者2级。 则最后一跳只有两种可能，所以F(n) = F(n-1) +
    // F(n-2)
    // 现在青蛙可以跳n级。 假设台阶为n级，则青蛙可以 跳一次或者多次。 一次： 直接跳n级，这是一种方法。 多次： 青蛙跳到 1到n-1级
    // 任一级（不管怎样跳，跳几次）后再跳一次到n级。
    // 或者这样分析，青蛙最后一跳，有可能是从起点直接跳到终点，或者从起点跳了若干步后(到达 1到n-1级中间任一级 )再跳到n级。
    // 所以总的方法数为：青蛙 跳到 1级到n-1级 每级可能的方法数（再跳到n级） + 1（直接跳到n级）
    // F(n) = F(n-1) + F(n-2) + ... + F(1) + 1;
    // 可得: F(n-1) = F(n-2) + F(n-3) +..._F(1) + 1;
    // 则F(n) = F(n-1) + F(n-1)
    // 即F(n) = 2F(n-1)

    int jumpFloorII(int number) {
        if (number <= 0)
            return 0;
        if (1 == number)
            return 1;
        return 2 * jumpFloorII(number - 1);
    }

}