
class Solution {
    public int binarySearchSortedArray(int[] nums, int start, int end, int target){
        
        if(nums.length == 0 || start>end){
            return -1;
        }
        int mid = (start + end) / 2;
        if(nums[mid] == target){
            return mid;
        }
        else if(nums[mid]<target){
            return binarySearchSortedArray(nums,mid+1,end,target);
        }
        else{
                return binarySearchSortedArray(nums,start,mid-1,target);
        }
            
        
        
    }   
    public int search(int[] nums, int target) {
        return binarySearchSortedArray(nums,0,nums.length-1,target);
    }
}