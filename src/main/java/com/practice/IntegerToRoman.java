package com.practice;

public class IntegerToRoman {
    public String intToRoman(int num) {

        if(num > 3999 || num < 1 )
            return "";

        int [] values= {1000,900, 500,400,100,90,50,40,10,9,5,4,1};
        String [] symbols= {"M","CM", "D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        // 58
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < values.length && num > 0 ;i++){
            while(num >= values[i]){
                num-=values[i];
                sb.append(symbols[i]);
            }
        }
        return sb.toString();
    }
}
