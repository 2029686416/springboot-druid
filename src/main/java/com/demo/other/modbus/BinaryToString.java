package com.demo.other.modbus;
/**
*@author:liuhao
*@version:2020年4月30日下午1:13:01
*@description:
*/
public class BinaryToString {
	public static void main(String[] args) {
        String binary = "1100001 1100010 1100011";      
        System.out.println(toString(binary));
    }

    public static String toString(String binary) {
         String[] tempStr=binary.split(" ");
            char[] tempChar=new char[tempStr.length];
            for(int i=0;i<tempStr.length;i++) {
               tempChar[i]=BinstrToChar(tempStr[i]);
            }
            return String.valueOf(tempChar);
    }


    //将二进制字符串转换成int数组
    public static int[] BinstrToIntArray(String binStr) {       
        char[] temp=binStr.toCharArray();
        int[] result=new int[temp.length];   
        for(int i=0;i<temp.length;i++) {
            result[i]=temp[i]-48;
        }
        return result;
    }


    //将二进制转换成字符
    public static char BinstrToChar(String binStr){
        int[] temp=BinstrToIntArray(binStr);
        int sum=0;
        for(int i=0; i<temp.length;i++){
            sum +=temp[temp.length-1-i]<<i;
        }   
        return (char)sum;
   }
}
