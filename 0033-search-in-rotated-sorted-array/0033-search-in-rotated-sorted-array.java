class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
       
        while(low<=high){
            int mid = (low + high) / 2;
            if(nums[mid] == target) return mid;
            if(nums[low]<=nums[mid]){  //left side is sorted
                if(nums[low]<= target && nums[mid]>=target){
                    //eliminate right side - because answer is in left half confirmed
                    high = mid-1;
                }
                else {
                    low = mid + 1;
                }
            }
            else{
                if(target>=nums[mid] && target<=nums[high]){
                    //answer lies in the right
                    low = mid + 1;
                }
                else {
                    high = mid - 1;
                }
            }
        }
        return -1;

    }
}