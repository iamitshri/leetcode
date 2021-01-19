package com.practice;

public class ArrayOfArrayProducts {

    static int[] arrayOfArrayProducts(int[] arr) {

        if(arr==null || arr.length==0)
            return new int[0];

        if(arr.length==1)
            return arr;

        int a[] = new int[arr.length];
        int product = 1;
        a[0]=1;
        for (int i = 1; i < arr.length; i++) {
            product *= arr[i - 1];
            a[i] = product;
        }
        //  arr        [2 3 4 ]
        //          a  [2 2 6]
                     //[12 8 6]
        //  end result [12 8 6]
        int prodRight = 1;
        for (int i = arr.length - 2; i >= 0; i--) {
            prodRight *= arr[i + 1];
            a[i] *= prodRight;
        }
        return a;
    }

    public static void main(String[] args) {
        final int[] ints = arrayOfArrayProducts(new int[]{2, 3, 4});
        for (int i : ints) {
            System.out.print(i+" ");
        }

    }


}
