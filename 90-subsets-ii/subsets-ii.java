class Solution {
    List<List<Integer>> answer = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
      Arrays.sort(nums);
      sub(nums,0,new ArrayList<>());
      return answer;
    }
    private void sub(int nums[],int start,List<Integer> current){
        answer.add(new ArrayList<>(current));
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
        current.add(nums[i]);

        sub(nums,i+1,current);

        current.remove(current.size()-1);
        }

    }
}   
