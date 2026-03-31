import java.util.*;
class Solution {
    static final int INT_MIN_VAL = -2147483648;
    static final int INT_MAX_VAL = 2147483647;

    static int convertString(String s,int i,long num, int sign){
        //Out of string length or notaDigit is found
        if(i>=s.length() || !Character.isDigit(s.charAt(i)) ){
            return (int)(sign*num);

          
        }
        num = num*10 + (s.charAt(i) - '0');
        if(sign*num <= INT_MIN_VAL) return INT_MIN_VAL;
        if(sign*num >= INT_MAX_VAL) return INT_MAX_VAL;

        return convertString(s,i+1,num,sign);

    }
    public int myAtoi(String s) {
        int i =0;

        //within string & white space -> ignore
        while(i<s.length() && s.charAt(i)==' ') i++;

        int sign = 1;
        if(i<s.length() && (s.charAt(i)=='+' || s.charAt(i)=='-')){
            sign = (s.charAt(i)=='-')? -1:1;
            i++;
        }
        return convertString(s,i,0,sign);


    }
}