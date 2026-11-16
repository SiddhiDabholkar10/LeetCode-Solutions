class Solution {
    public int totalFruit(int[] fruits) {
        int l=0, r = 0, maxLen = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        int n = fruits.length;
        while(r<n){
            freq.put(fruits[r],freq.getOrDefault(fruits[r],0)+1);
            if(freq.size()>2){
                freq.put(fruits[l],freq.getOrDefault(fruits[l],0)-1);
                if(freq.get(fruits[l])==0){
                    freq.remove(fruits[l]);
                }
                l++;
            }
            if(freq.size()<=2){
                    maxLen = Math.max(maxLen, r-l+1);
                    
            }
            r++;
        }
        return maxLen;
    }
}