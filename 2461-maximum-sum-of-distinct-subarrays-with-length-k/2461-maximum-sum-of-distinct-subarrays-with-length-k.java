class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long maxSum = 0;
        long windowSum = 0;
        int start = 0;
        Map<Integer, Integer> freq = new HashMap<>();
        for(int end=0;end<nums.length;end++){
            windowSum += nums[end];
            freq.put(nums[end],freq.getOrDefault(nums[end],0)+1);
            if(end-start+1 == k){
                if(freq.size() == k){
                    maxSum = Math.max(maxSum, windowSum);
                }
                windowSum -= nums[start];
                freq.put(nums[start], freq.get(nums[start]) - 1);
               
                if(freq.get(nums[start])==0){
                    freq.remove(nums[start]);
                }
                start++;
            }
           
        }
        return maxSum;
    }
}