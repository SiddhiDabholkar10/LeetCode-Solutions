class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        List<int[]> merged = new ArrayList<>();
        for(int[] interval: intervals){
            //List of merged is empty or new interval is starting in the List
            if(merged.isEmpty() || interval[0] > merged.get(merged.size()-1)[1]){
                merged.add(interval);
            }
            else{
                int[] lastInterval = merged.get(merged.size()-1);
                lastInterval[1] = Math.max(lastInterval[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}