class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for(int end=0; end<s.length(); end++){
            char ch = s.charAt(end);
            if(lastSeen.containsKey(ch)){
                start = Math.max(lastSeen.get(ch)+1, start);
            }
            lastSeen.put(ch, end);
            maxLen = Math.max(maxLen, end-start+1);
        }
        return maxLen;
    }
}