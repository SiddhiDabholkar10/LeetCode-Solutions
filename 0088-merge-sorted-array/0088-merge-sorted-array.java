class Solution {
    public void swapIfgreater(int[] a,int[] b, int left, int right){
        if(a[left] > b[right]){
            int temp = a[left];
            a[left] = b[right];
            b[right] = temp;
        }
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m + n;
        int gap = len/2 + len%2;
        while(gap>0){
            int left = 0;
            int right = left + gap;
            while(right<len){
                if(left<m && right>=m){
                    swapIfgreater(nums1,nums2,left, right-m);
                }else if(left>m){
                    swapIfgreater(nums2,nums2, left-m, right-m);
                }else{
                    swapIfgreater(nums1,nums1, left,right);
                }
                left++;
                right++;
            }
            if (gap == 1) break;
            gap = gap/2 + gap%2;
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}