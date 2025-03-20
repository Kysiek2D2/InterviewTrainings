package leetcode.TopInterviewQuestionsCollection;

class ArraySolutions {
    /**
     * REMOVE DUPLICATES FROM SORTED ARRAY
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
     * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
     * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
     * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
     * Return k.
     * EXAMPLE:
     * Input: nums = [1,1,2]
     * Output: 2, nums = [1,2,_]
     * Explanation: Your function should return k = 2, with the first two elements of nums being 1 and 2 respectively.
     * It does not matter what you leave beyond the returned k (hence they are underscores).
     */
    public int removeDuplicates(int[] nums) {
        //TIP: two-pointer approach used
        int currentNumber = nums[0];
        int result = 0;
        //Start from index 1vvvv
        for(int i = 1; i < nums.length; i++) {
            if(!(nums[i] == currentNumber)){
                currentNumber = nums[i];
                result++;
                nums[result] = currentNumber;
            }
        }
        return result + 1;
    }

    /**
     * Best Time to Buy and Sell Stock II
     * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
     * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
     * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time. However, you can buy it then immediately sell it on the same day.
     * Find and return the maximum profit you can achieve.
     * EXAMPLE:
     * Input: prices = [7,1,5,3,6,4]
     * Output: 7
     * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
     * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
     * Total profit is 4 + 3 = 7.
     */
    public int maxProfit(int[] prices) {
        int total = 0;
        int currValue = 0;
        boolean isBought = false;
        //Loop until length - 1, so we won't fall in ArrayOutOfBoundsException
        for(int i = 0; i < prices.length - 1; i++){
            if(isBought == false && (prices[i+1] > prices[i])){
                currValue+=prices[i]; //buy
                isBought = true;
            } else if (isBought == true &&
                    (prices[i+1] < prices[i])){
                total += (prices[i]-currValue); //sell
                currValue = 0;
                isBought = false;
            }
        }
        if(isBought == true){
            total += (prices[prices.length-1]-currValue); //sell since it's last call
        }
        return total;
    }
}