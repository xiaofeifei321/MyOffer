package com.ccut.offer;
/**
*把字符串转换成整数
 */
public class Problem49 {
    //边界条件判断条件
	//数据上下 溢出 空字符串 只有正负号，错误标志输出；
	public int StringToInt(String str){
        //if(str.equals("")||str.length()==0)
		if(str==null||str.length()==0){
			return 0;
		}
		int fuhao=0;
		//
		char chars[] = str.toCharArray();
		if(chars[0]=='-') fuhao=1;
		int sum=0;
		for(int i=fuhao;i<chars.length;i++){
			if(chars[i]=='+'){
				continue;
			}
			// 0-9对应 48-57 A-Z对应 65-90 a-z对应 97-122
			// 第33～126号(共94个)是字符；
			if(chars[i]<48||chars[i]>57){
				return 0;
			}
			sum = sum*10+chars[i]-48;
		}
		return fuhao ==0?sum:sum*(-1);
	}
 
	public int StrToInt(String str) {
        if(str.equals("")||str.length()==0) return 0;
        int sign = 0;
        char[] chars = str.toCharArray();
        if(chars[0]=='-')
        	sign =1;
        int sum = 0;
        //i=sign(if sign=1，skip the '-' signal;
        for(int i=sign;i<chars.length;i++){
            if(chars[i]=='+'){
                continue;
            }
            // 0-9 --> 48-57(ASCII码)
            if(chars[i]<48||chars[i]>57)
            	return 0;
            sum = sum*10+chars[i]-48;
        }
        if(sign!=0) sum = sum*(-1);
        return sum;
    }
 
	public static void main(String[] args) {
 
        String str = "-123";
        System.out.println(new Problem49().StringToInt(str));
 
        Problem49 t = new Problem49();
        System.out.println(t.StrToInt(str));
	}
}