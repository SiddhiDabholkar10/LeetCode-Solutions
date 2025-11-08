class Solution {
    public String removeOuterParentheses(String s) {
        if (s == ""){
            return s;
        }
        StringBuilder output = new StringBuilder();
        int depth = 0;
        for(char c : s.toCharArray()){
            if(c=='('){
                //Already inside parent ()
                if(depth>0){
                    //added ( in new string
                    output.append('(');
                }
                depth++;
            }
            if(c==')'){
                //We are already in parent ()
                depth--;
                if(depth>0){
                    //added ) in new string
                    output.append(')');
                }
            }
        }
        return output.toString();
    }
}