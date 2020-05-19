package com.automation.tests.practice;

public class Review {

    public static void arr1() {
        int[] arr1 = {1, 2, 3, 4, 5,};
        for (int e = 0; e < arr1.length; e = e + 2) {
            System.out.print(arr1[e]);
        }
    }
    public static void loop(){
        String [] arr = {"A", "B", "C", "D"};
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            if (arr[i].equals("C")){
                continue;
            }
            System.out.println("Job done");
            break;
        }
    }

    public static void main(String[] args) {
//        arr1();
        loop();
    }
}
