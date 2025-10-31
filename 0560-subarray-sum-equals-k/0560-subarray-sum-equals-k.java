import java.util.*;
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n= nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0;
        int count = 0;
        map.put(0,1);   //sum zero is 1 time
        for(int i=0;i<n;i++){
            preSum += nums[i];
            int rem = preSum - k;
            count+=map.getOrDefault(rem,0);
            map.put(preSum,map.getOrDefault(preSum,0)+1);

        }
        return count;
    }
}