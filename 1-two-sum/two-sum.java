class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++){
            int number= target - nums[i];
            for(int j=0;j<i;j++){
                if(nums[j]==number){
                    return new int[] {i,j};

                }
            }
        }
        return new int[0];  
    }
}