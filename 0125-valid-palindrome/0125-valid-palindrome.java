class Solution {
    public boolean isPalindrome(String s) {
         if(s.isEmpty()){
            return true;
        }
        int beg = 0;
        int end = s.length() - 1;
        while( beg<=end){
            char currBeg = s.charAt(beg);
            char currEnd = s.charAt(end);
            if(Character.isLetterOrDigit(currBeg) == false){
                beg++;
            }
            else if(Character.isLetterOrDigit(currEnd) == false){
                end--;
            }else{
                if(Character.toLowerCase(currBeg)!= Character.toLowerCase(currEnd)){
                    return false;
                }
                beg++;
                end--;
            }
        }
        return true;
    }
}