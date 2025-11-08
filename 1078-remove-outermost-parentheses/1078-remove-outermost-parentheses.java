class Solution {
    public String removeOuterParentheses(String s) {
        if (s == ""){
            return s;
        }
        StringBuilder output = new StringBuilder();
        int depth = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                if(depth>0){
                    output.append('(');
                }
                depth++;
            }
            if(c==')'){
                depth--;
                if(depth>0){
                    output.append(')');
                }
            }
        }
        return output.toString();
    }
}