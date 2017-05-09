package com.task.schedule.test;

import java.text.DecimalFormat;

public class DigitalConvert {

    static final String zhnum_0 = "零壹贰叁肆伍陆柒捌玖";

    static final String zhnum = "零一二三四五六七八九";

    static final String[] zhnum1 = { "", "十", "百", "千" };

    static final String[] zhnum1_0 = { "", "拾", "佰", "仟" };

    static final String[] zhnum2 = { "", "万", "亿", "万亿", "亿亿" };


    private static String numberToZH4(String s, boolean fan) {
        StringBuffer sb = new StringBuffer();
        if (s.length() != 4)
            return null;
        for (int i = 0; i < 4; i++) {
            char c1 = s.charAt(i);
            if (c1 == '0' && i > 1 && s.charAt(i - 1) == '0')
                continue;
            if (c1 != '0' && i > 1 && s.charAt(i - 1) == '0')
                sb.append('零');
            if (c1 != '0') {
                if (fan) {
                    sb.append(zhnum_0.charAt(c1 - 48));
                    sb.append(zhnum1_0[4 - i - 1]);
                } else {
                    sb.append(zhnum.charAt(c1 - 48));
                    sb.append(zhnum1[4 - i - 1]);
                }
            }
        }
        return new String(sb);
    }

    public static String numberToZH(long n, boolean fan) {
        StringBuffer sb = new StringBuffer();
        String strN = "000" + n;
        int strN_L = strN.length() / 4;
        strN = strN.substring(strN.length() - strN_L * 4);
        for (int i = 0; i < strN_L; i++) {
            String s1 = strN.substring(i * 4, i * 4 + 4);
            String s2 = numberToZH4(s1, fan);
            sb.append(s2);
            if (s2.length() != 0)
                sb.append(zhnum2[strN_L - i - 1]);
        }
        String s = new String(sb);
        if (s.length() != 0 && s.startsWith("零"))
            s = s.substring(1);
        return s;
    }

    public static String numberToZH(double d, boolean fan) {
        return numberToZH("" + d, fan);
    }

    public static String numberToZH(String str, boolean fan) {
        StringBuffer sb = new StringBuffer();
        int dot = str.indexOf(".");
        if (dot < 0)
            dot = str.length();

        String zhengshu = str.substring(0, dot);
        sb.append(numberToZH(Long.parseLong(zhengshu), fan));
        if (dot != str.length()) {
            sb.append("点");
            String xiaoshu = str.substring(dot + 1);
            for (int i = 0; i < xiaoshu.length(); i++) {
                if (fan) {
                    sb.append(zhnum_0.charAt(Integer.parseInt(xiaoshu
                            .substring(i, i + 1))));
                } else {
                    sb.append(zhnum.charAt(Integer.parseInt(xiaoshu.substring(
                            i, i + 1))));
                }
            }
        }
        String s = new String(sb);
        if (s.startsWith("零"))
            s = s.substring(1);
        if (s.startsWith("一十"))
            s = s.substring(1);
        while (s.endsWith("零")) {
            s = s.substring(0, s.length() - 1);
        }
        if (s.endsWith("点"))
            s = s.substring(0, s.length() - 1);
        return s;
    }

    public static String numberToRMB(double rmb) {
        String strRMB = "" + rmb;
        DecimalFormat nf = new DecimalFormat("#.#");
        nf.setMaximumFractionDigits(2);
        strRMB = nf.format(rmb).toString();
        strRMB = numberToZH(strRMB, true);
        if (strRMB.indexOf("点") >= 0) {
            strRMB = strRMB + "零";
            strRMB = strRMB.replaceAll("点", "圆");
            String s1 = strRMB.substring(0, strRMB.indexOf("圆") + 1);
            String s2 = strRMB.substring(strRMB.indexOf("圆") + 1);
            strRMB = s1 + s2.charAt(0) + "角" + s2.charAt(1) + "分整";
        } else {
            strRMB = strRMB + "圆整";
        }
        return "人民币(大写):" + strRMB;
    }
    /*大写转小写数字*/
   /* public int ChineseToNumber(String str){
        String str1 = new String();
        String str2 = new String();
        String str3 = new String();
        int k = 0;
        boolean dealflag = true;
        for(int i=0;i<str.length();i++){//先把字符串中的“零”除去
            if('零' == (str.charAt(i))){
                str = str.substring(0, i) + str.substring(i+1);
            }
        }
        String chineseNum = str;
        for(int i=0;i<chineseNum.length();i++){
            if(chineseNum.charAt(i) == '亿'){
                str1 = chineseNum.substring(0,i);//截取亿前面的数字，逐个对照表格，然后转换
                k = i+1;
                dealflag = false;//已经处理
            }
            if(chineseNum.charAt(i) == '万'){
                str2 = chineseNum.substring(k,i);
                str3 = str.substring(i+1);
                dealflag = false;//已经处理
            }
        }
        if(dealflag){//如果没有处理
            str3 =  chineseNum;
        }
        int result = sectionChinese(str1) * 100000000 +
                sectionChinese(str2) * 10000 + sectionChinese(str3);
        return result;
    }

    public int sectionChinese(String str){
        int value = 0;
        int sectionNum = 0;
        for(int i=0;i<str.length();i++){
            int v = (int) Tool.intList.get(str.charAt(i));
            if( v == 10 || v == 100 || v == 1000 ){//如果数值是权位则相乘
                sectionNum = v * sectionNum;
                value = value + sectionNum;
            }else if(i == str.length()-1){
                value = value + v;
            }else{
                sectionNum = v;
            }
        }
        return value;
    }*/

    public static void main(String[] args) {
        System.out.println(numberToRMB(123));
    }


}
