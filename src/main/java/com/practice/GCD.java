package com.practice;

public class GCD {

    public static void main(String[] args) {
        if(gcdRecursive(12,15) ==gcd(12,15)){
            System.out.println("true");
        }
    }
    public static int gcd(int a, int b){
        while(b != 0 ){
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }

    public static int gcdRecursive(int a, int b){
        if(b!=0)
            return gcd(b,a%b);
        return a;
    }

    public static int gcd3(int num1, int num2) {

        // Base case
        if (num1 == num2) {
            return num1;
        }
        // Recursive case
        if (num1 > num2) {
            return gcd3(num1-num2, num2);
        }
        else {
            return gcd3(num1, num2-num1);
        }
    }

}
