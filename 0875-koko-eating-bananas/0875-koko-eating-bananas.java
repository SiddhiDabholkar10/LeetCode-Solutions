class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int n = piles.length;
        int ans = -1;
        while(low<=high){
            int mid = low + (high-low)/2;
            long hoursTaken = 0;
            for(int i=0;i<n;i++){
                hoursTaken += (long) Math.ceil((double) piles[i]/mid);
            }
            if(hoursTaken <= h){
                ans = mid;
                high = mid -1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}