class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0;
        int j = 1;
        int n = nums.length;
        int[] res = new int[n];
        for(int k =0;k<n;k++){
            if(nums[k]<1){
                res[j] = nums[k];
                j += 2;
            }else{
                 res[i] = nums[k];
                i+=2;
            }
           
            
        }
        return res;
    }
}