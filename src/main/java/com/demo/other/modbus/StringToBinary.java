package com.demo.other.modbus;
/**
*@author:liuhao
*@version:2020年4月30日下午1:12:30
*@description:
*/
public class StringToBinary {
	public static void main(String[] args) {
        String str = "3";
        String binary = toBinary(str);
        System.out.println(binary);
    }

    public static String toBinary(String str){
        //把字符串转成字符数组
        char[] strChar=str.toCharArray();
        String result="";
        for(int i=0;i<strChar.length;i++){
            //toBinaryString(int i)返回变量的二进制表示的字符串
            //toHexString(int i) 八进制
            //toOctalString(int i) 十六进制
            result +=Integer.toBinaryString(strChar[i])+ " ";
        }
        return result;
    }
}
