class Solution {
    public List<Integer> getRow(int rowIndex) {
        int n = rowIndex+1;
        long ans = 1L;
        List<Integer> row = new ArrayList<>();
        row.add((int)ans);
        for(int i=1;i<n;i++){
            ans = ans * (n-i);
            ans = ans /i;
            row.add((int)ans);
        }
        return row;
    }
}