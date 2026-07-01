class Solution {

    public List<Integer> generateOneRow(int n){
        List<Integer> oneRow = new ArrayList<>();
        int ans = 1;
        if (n==1){
            oneRow.add(ans);
            return oneRow;
        }else{
            oneRow.add(ans);
            for(int i=1;i<n;i++){            
                ans = ans*(n-i);
                ans = ans/i;
                oneRow.add(ans);

            }
            return oneRow;
        }
        
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            pascal.add(generateOneRow(i));
        }
        return pascal;

       

        
    }
}