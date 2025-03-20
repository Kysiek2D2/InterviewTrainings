package leetcode.TopInterviewQuestionsCollection;

class ArraySolutions {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++) {
            if(!(i+2 >= nums.length)){
                if(nums[i] == nums[i+1]){
                    nums[i+1] = nums[i+2];
                }
            } else {
                if(nums[i] == nums[i+1]){
                    nums[i+1] = 0;
                    return result;
                }
            }
        }
        return result;
    }
}