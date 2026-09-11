class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;

        for(int i=0;i<=n-1;i++){

              nums[i]=nums[i] * nums[i];

        }
        Arrays.sort(nums);
        return nums;
    }
}