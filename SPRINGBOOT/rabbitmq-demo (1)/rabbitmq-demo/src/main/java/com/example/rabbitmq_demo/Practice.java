package com.example.rabbitmq_demo;
import java.sql.Array;
import java.util.*;
import java.io.*;
import java.nio.*;
import java.lang.*;
import java.sql.*;
public class Practice extends ArrayList {
    public static void main(String[] args){
        byte b=0;
        short s=1;
        int i=2;
        long l=3;
        float f=4;
        double d=5;
        char c='a';
        boolean bo=true;
        Byte by=0;
        Short sh=1;
        Integer in=2;
        Long lo=3L;
        Float fl=4F;
        Double dou=5D;
        Character ch='a';
        Boolean boo=true;
        byte[] byt=new byte[0];
        short[] sho=new short[1];
        int[] inte=new int[2];
        long[] lon=new long[3];
        float[] flo=new float[4];
        double[] doub=new double[5];
        char[] cha=new char[6];
        boolean[] bool=new boolean[7];
        Byte[] bytes=new Byte[0];
        Short[] shorts=new Short[1];
        Integer[] integers=new Integer[2];
        Long[] longs=new Long[3];
        Float[] floats=new Float[4];
        Double[] doubles=new Double[5];
        Character[] characters=new Character[6];
        Boolean[] booleans=new Boolean[7];
        byte[] bytes1={0,1};
        short[] shorts1={2,3};
        int[] ints={4,5};
        long[] longs1={6,7};
        float[] floats1={8.8f,9.9f};
        double[] doubles1={10.10,11.11};
        char[] chars={'a','b'};
        boolean[] booleans1={true,false};
        Byte[] bytes2={0,1};
        Short[] shorts2={2,3};
        Integer[] integers1={4,5};
        Long[] longs2={6L,7L};
        Float[] floats2={8.8F,9.9F};
        Double[] doubles2={10.10,11.11};
        Character[] characters1={'a','b'};
        Boolean[] booleans2={true,false};
//        System.out.println(b+" "+by+" "+byt+" "+bytes+" "+bytes1+" "+bytes2);
//        Scanner scanner=new Scanner(System.in);
//        String string=scanner.nextLine();
//        System.out.println(string);
//        Long l1=scanner.nextLong();
//        System.out.println(l1);
//        for(int num=1;num<=10;num++){
//            System.out.println(num);
//        }
//        for(int x:ints){
//            System.out.println(x);
//        }
//        int num0=1;
//        while (num0<=10){
//            System.out.println(num0);
//            num0++;
//        }
//        int num1=1;
//        do{
//            System.out.println(num1);
//            num1++;
//        }while (num1<=10);
        int day=3;
        switch (day){
            case 1:
                System.out.println("mon");
                break;
            case 2:
                System.out.println("tue");
                break;
            case 3:
                System.out.println("wed");
                break;
                default:
        }
        String user="jiyan";
        if (user=="doremon"){
            System.out.println("registered user");
        }else if(user=="nobita"){
            System.out.println("registered but not authorized");
        }else{
            System.out.println("please registered");
        }
    }
}