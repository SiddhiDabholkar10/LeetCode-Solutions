class Solution {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int min = Integer.MAX_VALUE;
       
        while(low<=high){
            int mid = (low + high) / 2;
            if(nums[mid] <= min ) min = nums[mid];
            if(nums[low]<=nums[mid]){  //left side is sorted so what's make sure you know what's sorted on left half
                min = Math.min(nums[low],min);
                low = mid+1;
               
            }
            else{
                //right is sorted - find what's min on right half
                min = Math.min(nums[mid],min);
                high = mid -1;
            }
        }
        return min;
    }
}