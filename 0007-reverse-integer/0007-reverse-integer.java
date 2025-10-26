class Solution {
    public int reverse(int x) {
        int rev = 0;
        while(x != 0){
            if(rev != rev * 10 / 10)
                return 0;
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return rev;
    }
}