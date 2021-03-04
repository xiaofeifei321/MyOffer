package com.labuladong;

public class Test {
    public static String REGEX = "^[Ee]:/(.+)\\.m3u8$";

    public static void main(String[] args) {
        String temp = "E:\\8M\\teleplay\\budaiheshangxinchuan\\budaiheshangxinchuan_57\\budaiheshangxinchuan_57_H265_8M_4K.m3u8";
        String temp1 = "E:\\H264_8M\\teleplay\\budaiheshangxinzhuang\\budaiheshangxinchuan_57\\budaiheshangxinchuan_57_H264_8M_4K.m3u8";
        System.out.println(temp.replaceAll("\\\\", "/")
                .replaceAll(REGEX, "http://shenhe.ott.4kgarden.net/OTT/" + "H264_" + "$1.m3u8")
                .replaceAll("_H265_", "_H264_"));
        System.out.println(temp1.replaceAll("\\\\", "/")
                .replaceAll(REGEX, "http://shenhe.ott.4kgarden.net/OTT/" + "H264_" + "$1.m3u8")
                .replaceAll("_H265_", "_H264_"));



    }
}
