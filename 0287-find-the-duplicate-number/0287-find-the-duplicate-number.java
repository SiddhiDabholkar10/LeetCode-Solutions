class Solution {
    public int findDuplicate(int[] nums) {
        int i=0;
        while(i<nums.length){
            int correctIndex = nums[i]-1;
            if(i==correctIndex){
                i++;
            }else if(nums[i] == nums[correctIndex]){
                return nums[i];
            }
            else{
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            }
        }
        return -1;
    }
}