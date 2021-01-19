package com.practice;

public class FindNonRepeating {

    public static void main(String[] args) {
        int [] arr = new int []{1,1,2,3,4,4,5,5};
        FindNonRepeating f = new FindNonRepeating();
        f.findNonRepeating(arr);
    }

    private void findNonRepeating(int[] arr) {

        int xor=0;
        for(int i =0 ; i < arr.length ; i++){
            xor ^=arr[i];
        }

        int lastSetBit = xor & ~(xor-1);
    int x = 0,y = 0;
        for(int i=0;i< arr.length;i++)
            if((arr[i] & lastSetBit) !=1 )
                x ^= arr[i];
            else
                y^= arr[i];

        System.out.println("Non Repeating x:"+x);
        System.out.println("Non Repeating y:"+y);
    }
}
