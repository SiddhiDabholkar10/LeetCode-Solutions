class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if (n==0) return 0;
        int longest = 1;
        Set<Integer> u_set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            u_set.add(nums[i]);
        }
        for(int x : u_set){
            if(!u_set.contains(x-1)) {
                //start sequence
                int count = 1;
                int curr = x;
                while(u_set.contains(curr+1)){
                    curr++;
                    count++;
                }
                longest = Math.max(longest, count);

            }
        }
        return longest;

    }
}