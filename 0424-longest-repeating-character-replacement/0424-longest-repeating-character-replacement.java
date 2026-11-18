class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen =0;
        int start =0;
        int[] freq = new int[26];
        int maxFreq = 0;
        for(int end=0;end<s.length();end++){
            freq[s.charAt(end)-'A']++;
            maxFreq= Math.max(maxFreq, freq[s.charAt(end)-'A']);
            //too many changes required
            if((end-start+1)-maxFreq > k){
                freq[s.charAt(start)-'A']--;
                start++;
            }
            maxLen = Math.max(maxLen,end-start+1);
            
        }
        return maxLen;
    }
}