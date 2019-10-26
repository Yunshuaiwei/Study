package com.study.team.view;

import java.util.Scanner;

/**
 * @ProjectName Project01
 * @ClassName TSUtility
 * Description
 * @Auther YunSW
 * @Date 2019/10/26 11:04
 * @Version 1.0
 **/
public class TSUtility {
    private static Scanner scanner =new Scanner(System.in);
    /**
     * 读取键盘，如果用户输入‘1’--‘4’中的任意字符，则方法返回。
     */
    public static char readMenuSelection(){
        char c;
        for( ; ; ){
            String str=readKeyBoard(1,false);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'){
                System.out.println("选择错误，请重新输入：");
            }else break;
        }
        return c;
    }
    /**
     * 该方法提示并等待，知道用户按回车后返回
     */
    public static void readReturn(){
        System.out.println("按回车键继续...");
        readKeyBoard(100,true);
    }
    /**
     * 该方法从键盘读取一个长度不超过两位的整数，并将其作为方法的返回值
     */
    public static int readInt(){
        int n;
        for(; ; ){
            String str=readKeyBoard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }catch(NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    /**
     * 从键盘读取‘Y’或‘N’，并将其作为方法的返回值。
     */
    public static char readConfirmSelection(){
        char c;
        for(; ; ){
            String str=readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else{
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }
    private static String readKeyBoard(int limit,boolean blankReaturn){
        String line="";
        while(scanner.hasNextLine()){
            line =scanner.nextLine();
            if(line.length()==0){
                if(blankReaturn)return line;
                else continue;
            }
            break;
        }
        return line;
    }
}
