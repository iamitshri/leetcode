package com.practice;

public class AmazonFreshPromotion {

    //https://github.com/crazy-developers-dev/AmazonOA/blob/master/P1_AmazonFreshPromotion.java
//TODO

    public static void main(String[] args) {
        String[] cart = {"a", "b"};
        String[][] codes = {{"a"}, {"b"}};
        int result = freshPromotion(codes, cart);
        System.out.println("result:" + result);

        String[] shoppingCart1 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        String[][] codeList1 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        System.out.println(freshPromotion(codeList1, shoppingCart1)); // 1

        String[][] codeList2 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart2 = {"banana", "orange", "banana", "apple", "apple"};
        System.out.println(freshPromotion(codeList2, shoppingCart2)); // 0

        String[][] codeList3 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart3 = {"apple", "banana", "apple", "banana", "orange", "banana"};
        System.out.println(freshPromotion(codeList3, shoppingCart3)); // 0

        String[][] codeList4 = {{"apple", "apple"}, {"apple", "apple", "banana"}};
        String[] shoppingCart4 = {"apple", "apple", "apple", "banana"};
        System.out.println(freshPromotion(codeList4, shoppingCart4)); // 0

        String[][] codeList5 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart5 = {"orange", "apple", "apple", "banana", "orange", "banana"};
        System.out.println(freshPromotion(codeList5, shoppingCart5)); // 1

        String[][] codeList6 = {{"apple", "apple"}, {"banana", "anything", "banana"}};
        String[] shoppingCart6 = {"apple", "apple", "orange", "orange", "banana", "apple", "banana", "banana"};
        System.out.println(freshPromotion(codeList6, shoppingCart6)); // 1

        String[][] codeList7 = {{"apple", "apple", "banana"}};
        String[] shoppingCart7 = {"apple", "apple", "apple", "banana"};
        System.out.println(freshPromotion(codeList7, shoppingCart7)); // 1
    }

    static int freshPromotion(String[][] codes, String[] cart) {

        if ( cart == null || cart.length == 0) {
            return 0;
        }

        if (codes == null || codes.length == 0 ) {
            return 1;
        }

        // {a a}
        // {a} {a}
        int i=0; int j=0;
        while(i < codes.length && j+codes[i].length <= cart.length){
            boolean match=true;
            for(int k=0; k < codes[i].length;k++){
                if(!codes[i][k].equals("anything") && !codes[i][k].equals(cart[j+k])){
                    match=false;
                    break;
                }
            }
            if(match){
                j+=codes[i].length;
                i++;
            }else{
                j++;
            }
        }

        return i==codes.length?1:0;

    }
}
