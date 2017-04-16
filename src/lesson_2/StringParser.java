package lesson_2;

import java.io.IOException;

/**
 * Created by WORKSTATION on 16.04.2017.
 */

public class Exceptions {


    public static int [][] parser(String s){

        int finalArray[][] = new int[4][4];
        String[] arr =  s.split("\n");

        for(int i = 0; i < arr.length; i++){
            String strNum[] = arr[i].split(" ");
            for (int j = 0; j < strNum.length; j++) {
                int num = Integer.parseInt(strNum[j]);
                finalArray[i][j] = num;
            }
        }
        System.out.println(finalArray);
        return finalArray;

    }

    public static void main(String[] args) {

        String initial_string = "1 3 1 2\n2 3 2 2\n5 6 7 1\n3 3 1 0";

        parser(initial_string);
//        try{
//            parser(initial_string);
//        }
//        catch(IOException e){
//
//        }finally{
//
//        }
    }
}
