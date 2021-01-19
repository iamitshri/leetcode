package com.practice;

public class PalindromDigit {

    public static void main(String[] args) {
        PalindromDigit pd = new PalindromDigit();

        boolean answer = pd.isPalindrome(100000101);
        System.out.println("isPalindrom:"+answer);
    }

    private boolean isPalindrome(int num) {
        if(num==0)
            return true;
        boolean result;

        int numDigits = (int)Math.log10(num)+1; // 4
        int nthMask = (int)Math.pow(10,numDigits-1); // 1000
        for(int i =0; i < (numDigits/2);i++){
            if(num/nthMask != num%10){
                return  false;
            }
            num = num%nthMask;
            num/=10;
            nthMask=nthMask/100;
        }
        return true;
    }
}
