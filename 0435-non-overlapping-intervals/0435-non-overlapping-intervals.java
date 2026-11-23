class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1],b[1]));
        int lastEnded = intervals[0][1];
        int n = intervals.length;
        
        if(n<=1){
            return 0;
        }
        int count = 1;
        for(int i=1;i<n;i++){
            if(lastEnded <= intervals[i][0]){
                //previous session ended before this started
                lastEnded = intervals[i][1];
                count++;
            }
        }
    return n-count;
        
    }
}