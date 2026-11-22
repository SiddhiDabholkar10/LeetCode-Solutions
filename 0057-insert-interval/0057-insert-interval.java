class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] merged = new int[n+1][2];
        int i=0;
        int count = 0;
        //while this interval begins and ends before newInterval begins - its before it definitely
        while(i<n && intervals[i][1]<newInterval[0]){
            merged[count] = intervals[i];
            count++;
            i++;
        }
        //while this interval begins before newInterval ends - it does end before newInterval begins otherwise it would be caught above
        while(i<n && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0],intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1],intervals[i][1]);
            i++;
        }
        merged[count] = newInterval;
        count++;
        while(i<n){
            merged[count] = intervals[i];
            i++;
            count++;
        }


        return Arrays.copyOf(merged, count);
    }
}