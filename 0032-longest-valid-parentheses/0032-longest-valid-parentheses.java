class Solution {
    
    public int longestValidParentheses(String s) {
        int open =0;
        int close = 0;
        int maxLen=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i) == '(') open++;
            else close++;
            if(close>open) {
                close =0; open = 0;
            }else if(close == open){
                maxLen = Math.max(maxLen, 2* close);            }
        }
        open =0;
        close = 0;
        for(int i=s.length()-1;i>=0; i--){
            if(s.charAt(i) == '(') open ++;
            else close++;
            if(open> close) {
                close =0; open = 0;
            }else if(close == open){
                maxLen = Math.max(maxLen, 2* close); 
        }
        
    }
    return maxLen;
    }
}