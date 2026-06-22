class Solution {
    public int reverse(int num) {
        long reversed = 0;
    
        while (num != 0) {
            reversed = reversed * 10 + (num % 10);
            num /= 10;
        }
        
        // Return 0 if the reversed number overflows the standard 32-bit int bounds
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0; 
        }
        
        return (int) reversed;
    }
}