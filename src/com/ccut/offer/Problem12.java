package com.ccut.offer;

/**
 * 数值的整次方
 *
 * @author root 实现函数double Power(double base,int exponent),
 * 求base的exponent次方。不得使用库函数，同时不需要考虑大数问题
 * <p>
 * 考察点：
 * 边界的条件
 */
public class Problem12 {

    public double power(double base, int exponent) throws Exception {
        double result = 0.0;
        if (equal(base, 0.0) && exponent < 0) {
            throw new Exception("0的负数次幂无意义");
        }
        if (equal(exponent, 0)) {
            return 1.0;
        }
        if (exponent < 0) {
            result = powerWithExponent(1.0 / base, -exponent);
        } else {
            result = powerWithExponent(base, exponent);
        }
        return result;
    }

    private double powerWithExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

    //判断两个double型数据，计算机有误差
    private boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) throws Exception {
        Problem12 test = new Problem12();
        System.out.println(test.power(3, -1));
    }
}
