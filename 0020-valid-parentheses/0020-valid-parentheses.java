class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '('); mapping.put('}', '{'); mapping.put(']', '['); //closing bracket as key
        for(char c: s.toCharArray()){

            //contains closing bracket -> needs opening bracket at stack top (correct kind)
            if(mapping.containsKey(c)){ 
                if(stack.isEmpty() || stack.peek()!=mapping.get(c)){
                    return false;
                }
                else stack.pop();
            }else{//contains opening bracket
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}