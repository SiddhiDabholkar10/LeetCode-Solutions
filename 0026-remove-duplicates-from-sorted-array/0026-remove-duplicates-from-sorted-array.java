class Solution {
    public int removeDuplicates(int[] nums) {
         // If array is empty, return 0
        if (nums.length == 0) return 0;

        // Pointer for last unique element
        int j = 0;

        // Start from second element
        for (int i = 1; i < nums.length; i++) {
            // If new unique element is found
            if (nums[i] != nums[j]) {
                // Move unique position forward
                j++;
                // Place new unique element
                nums[j] = nums[i];
            }
        }

        // i is last index of unique element, count = i + 1
        return j + 1;
    


    }
}