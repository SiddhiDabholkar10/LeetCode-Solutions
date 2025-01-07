class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count =0,max=0;
        int i=0;
        while(i<n){
            if(nums[i]==1){
                count++;
            }
            else{
               
                max = Math.max(count,max);
                count =0;
            }
            i++;
        }
        return Math.max(count,max);
    }
}