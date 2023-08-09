//https://leetcode.com/problems/number-of-valid-subarrays/
//VERY IMPORTANT QUESTION
//AGAIN VERY IMPORTANT QUESTION
import java.util.List;
import java.util.Stack;

public class noOfValidSubArray {
    public int validSubarrays(int[] nums) {
        Stack<Integer> numStack = new Stack<Integer>();
        Stack<Integer> indexStack = new Stack<Integer>();
        int length = nums.length;
        int[] endIndices = new int[length];
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (!numStack.isEmpty() && numStack.peek() > num) {
                numStack.pop();
                int prevIndex = indexStack.pop();
                endIndices[prevIndex] = i - 1;
            }
            numStack.push(num);
            indexStack.push(i);
        }
        while (!numStack.isEmpty()) {
            numStack.pop();
            int prevIndex = indexStack.pop();
            endIndices[prevIndex] = length - 1;
        }
        int subarraysCount = 0;
        for (int i = 0; i < length; i++) {
            int curLength = endIndices[i] - i + 1;
            subarraysCount += curLength;
        }
        return subarraysCount;
    }
    public static void main(String[] args) {
        noOfValidSubArray obj=new noOfValidSubArray();
        int[] nums={1,4,2,5,3};
        System.out.println(obj.validSubarrays(nums));
    }
}
