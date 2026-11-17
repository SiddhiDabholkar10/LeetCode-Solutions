class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        int start = 0; 
        Map<Character, Integer> lastSeen = new HashMap<>();
        for(int end =0; end <s.length(); end++){
            char ch = s.charAt(end);
            if(lastSeen.containsKey(ch)){
                start = Math.max(start, lastSeen.get(ch)+1);
            }
            lastSeen.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}