package com.practice;

import java.util.LinkedList;

public class IntegerToEnglishWords {


    String[] thousands = {"", "Thousand", "Million", "Billion"};

    String[] eleven = {"", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen",
        "Nineteen"};
    String[] numbers = {"Zero", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};


    public String numberToWords(int num) {

        if (num == 0) {
            return numbers[num];
        }
        // 123456
        LinkedList<String> lst = new LinkedList<>();
        int i = 0;
        while (num > 0) {

            if (num % 1000 != 0) {
                // 123456/100
                String s = numToString(num % 1000) + " " + thousands[i];
                lst.add(0, s);
            }
            i++;

            num = num / 1000;
        }

        return String.join(" ", lst)
                     .strip();
    }


    String numToString(int num) {
        if (num == 0) {
            return "";
        }
        LinkedList<String> lst = new LinkedList<>();
        if (num > 99) {//
            lst.add(numbers[num / 100]);
            lst.add("Hundred");
            // 234
            num = num % 100;
        }
        // 11 to 19
        if (num >= 11 && num < 20) {
            lst.add(eleven[num % 10]);
        } else if (num >= 10) {// 14
            lst.add(tens[num / 10]);
            num = num % 10;
            if (num > 0) {
                lst.add(numbers[num]);
            }
        } else if (num > 0 && num < 10) {
            lst.add(numbers[num]);
        }
        return String.join(" ", lst);
    }
}
