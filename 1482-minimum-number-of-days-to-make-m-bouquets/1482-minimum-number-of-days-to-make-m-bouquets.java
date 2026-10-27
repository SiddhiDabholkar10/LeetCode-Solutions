class Solution {
    private boolean canMakeBouquets(int[] bloomDay, int day, int m, int k){
        int consecutive = 0;
        int bouquets = 0;
        for(int bloom: bloomDay){
            //the flower can be used because it was bloomed
            if(bloom <= day){
                consecutive++;
                if(consecutive == k){
                    bouquets++;
                    consecutive = 0;
                }
            }else{
                //an unbloomed flower breaks the adjacent group
                consecutive = 0;
            }
        }
        return bouquets>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if((long)m * k > n) return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int answer = -1;
        while(low<=high){
            int mid = low+(high-low)/2;
            if(canMakeBouquets(bloomDay, mid, m, k)){
                answer = mid;
                high = mid-1; //go left, to get minimum
            }else{
                low = mid+1;
            }
        }
        return answer;
    }
}