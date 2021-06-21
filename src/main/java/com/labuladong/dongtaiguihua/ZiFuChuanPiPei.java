package com.labuladong.dongtaiguihua;

/**
 * ×Ö·û´®Æ¥Åä
 */
public class ZiFuChuanPiPei {

    int search(String pat, String txt) {
        int m = pat.length();
        int n = txt.length();
        for (int i = 0; i < m; i++) {
            System.out.println(pat.charAt(i));
        }
        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if (j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        ZiFuChuanPiPei ziFuChuanPiPei = new ZiFuChuanPiPei();
        String pat = "aaab";
        String txt = "aaacaaab";
        ziFuChuanPiPei.search(pat, txt);
    }

//        for (int i=0;i<=n-m;i++){
//            int j;
//            for (j=0;j<m;j++){
//                pat.charAt(j)
//            }
//        }


}
